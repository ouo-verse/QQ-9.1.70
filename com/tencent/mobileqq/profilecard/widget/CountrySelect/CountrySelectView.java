package com.tencent.mobileqq.profilecard.widget.CountrySelect;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CountrySelectView extends RelativeLayout implements IndexView.b {
    static IPatchRedirector $redirector_ = null;
    public static final String CODE_CHINA = "1";
    public static final String CODE_NO_SELECT = "0";
    private static final String INDEXES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NAME_CHINA = "\u4e2d\u56fd";
    public static final String NAME_NO_SELECT = "";
    private static final String TAG = "CountrySelectView";
    private static final String[] s_indexes;
    private final Context mContext;
    private String mCountryCode;
    private List<Object> mDataList;
    private LinkedHashMap<String, Integer> mIndexMap;
    private IndexView mIndexView;
    private PinnedDividerListView mListView;
    private OnCountrySelectListener mListener;
    private RelativeLayout mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class CountryAdapter extends PinnedDividerListView.a {
        static IPatchRedirector $redirector_ = null;
        private static final int COUNT_TYPE = 2;
        private static final int TYPE_DIVIDER = 0;
        private static final int TYPE_ITEM = 1;

        CountryAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountrySelectView.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
                return;
            }
            TextView textView = (TextView) view;
            Object item = getItem(i3);
            if (item instanceof DividerItem) {
                textView.setText(((DividerItem) item).indexStr);
            } else if (item instanceof BaseAddress) {
                textView.setText(((BaseAddress) item).pinyinFirst);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return CountrySelectView.this.mDataList.size();
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return R.layout.f168366u3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            return CountrySelectView.this.mDataList.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            return !(CountrySelectView.this.mDataList.get(i3) instanceof DividerItem) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view2 = view;
                view = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (getItemViewType(i3) == 0) {
                    if (view == null) {
                        view = LayoutInflater.from(CountrySelectView.this.mContext).inflate(getDividerLayout(), (ViewGroup) null);
                    }
                    ((TextView) view).setText(((DividerItem) getItem(i3)).indexStr);
                } else {
                    if (view == null) {
                        view = LayoutInflater.from(CountrySelectView.this.mContext).inflate(R.layout.f168367u4, (ViewGroup) null);
                        viewHolder = new ViewHolder();
                        viewHolder.nameTv = (TextView) view.findViewById(R.id.bar);
                        viewHolder.checkIv = (ImageView) view.findViewById(R.id.ax5);
                        view.findViewById(R.id.baq).setVisibility(8);
                        view.setTag(viewHolder);
                        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView.CountryAdapter.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CountryAdapter.this);
                                }
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                EventCollector.getInstance().onViewClickedBefore(view3);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view3);
                                } else {
                                    Object tag = view3.getTag();
                                    if (tag instanceof ViewHolder) {
                                        CountrySelectView.this.mListener.getSelectResult(((ViewHolder) tag).code);
                                    }
                                }
                                EventCollector.getInstance().onViewClicked(view3);
                            }
                        });
                    } else {
                        viewHolder = (ViewHolder) view.getTag();
                    }
                    BaseAddress baseAddress = (BaseAddress) getItem(i3);
                    viewHolder.nameTv.setText(baseAddress.name);
                    if (!TextUtils.isEmpty(CountrySelectView.this.mCountryCode) && CountrySelectView.this.mCountryCode.equals(baseAddress.code)) {
                        viewHolder.checkIv.setVisibility(0);
                    } else {
                        viewHolder.checkIv.setVisibility(8);
                    }
                    viewHolder.code = baseAddress.code;
                    if (AppSetting.f99565y) {
                        if (viewHolder.checkIv.getVisibility() == 0) {
                            view.setContentDescription(baseAddress.name + HardCodeUtil.qqStr(R.string.l4w));
                        } else {
                            view.setContentDescription(baseAddress.name);
                        }
                    }
                }
                view2 = view;
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
            }
            if (getItemViewType(i3) == 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class DividerItem {
        static IPatchRedirector $redirector_;
        public String indexStr;

        DividerItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface OnCountrySelectListener {
        void getSelectResult(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class ViewHolder {
        static IPatchRedirector $redirector_;
        public ImageView checkIv;
        public String code;
        public TextView nameTv;

        ViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            s_indexes = new String[]{"#", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z"};
        }
    }

    public CountrySelectView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mContext = context;
        initView();
        this.mListener = new OnCountrySelectListener() { // from class: com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CountrySelectView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView.OnCountrySelectListener
            public void getSelectResult(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                QLog.d(CountrySelectView.TAG, 4, "\u9009\u62e9\u4e86\u56fd\u5bb6\uff1a" + str);
            }
        };
    }

    private void getCountryInfo() {
        ((IProfileEditBusinessApi) QRoute.api(IProfileEditBusinessApi.class)).loadCountryInfo(MobileQQ.sMobileQQ.waitAppRuntime(null), new IProfileEditBusinessApi.OnCountryCacheLoadedListener() { // from class: com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountrySelectView.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.api.IProfileEditBusinessApi.OnCountryCacheLoadedListener
            public void onCountryInfoLoaded(List<Object> list) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    try {
                        CountrySelectView.this.initDataList(list);
                        return;
                    } catch (ClassCastException e16) {
                        QLog.e(CountrySelectView.TAG, 1, "getCountryInfo fail: " + e16.getMessage());
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDataList(List<BaseAddress> list) {
        this.mIndexMap = new LinkedHashMap<>();
        this.mDataList = new ArrayList(list.size() + 26);
        int i3 = 0;
        String str = "#";
        this.mIndexMap.put("#", 0);
        for (BaseAddress baseAddress : list) {
            if (!baseAddress.code.equals("0") && !baseAddress.code.equals("1")) {
                if (!baseAddress.pinyinFirst.equals(str)) {
                    str = baseAddress.pinyinFirst;
                    int indexOf = INDEXES.indexOf(str);
                    while (i3 <= indexOf) {
                        int i16 = i3 + 1;
                        this.mIndexMap.put(INDEXES.substring(i3, i16), Integer.valueOf(this.mDataList.size() + this.mListView.getHeaderViewsCount()));
                        i3 = i16;
                    }
                    this.mIndexMap.put(str, Integer.valueOf(this.mDataList.size() + this.mListView.getHeaderViewsCount()));
                    DividerItem dividerItem = new DividerItem();
                    dividerItem.indexStr = str;
                    this.mDataList.add(dividerItem);
                }
                this.mDataList.add(baseAddress);
            }
        }
        while (i3 < 26) {
            int i17 = i3 + 1;
            this.mIndexMap.put(INDEXES.substring(i3, i17), Integer.valueOf(this.mDataList.size() + this.mListView.getHeaderViewsCount()));
            i3 = i17;
        }
    }

    private void initHeaderView(String str, boolean z16) {
        String str2;
        int i3;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.f168367u4, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        TextView textView = (TextView) inflate.findViewById(R.id.bar);
        if (z16) {
            str2 = "";
        } else {
            str2 = NAME_CHINA;
        }
        textView.setText(str2);
        View findViewById = inflate.findViewById(R.id.ax5);
        String str3 = "0";
        if (!str.equals("0") && !str.equals("1")) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        findViewById.setVisibility(i3);
        inflate.findViewById(R.id.baq).setVisibility(8);
        if (!z16) {
            str3 = "1";
        }
        viewHolder.code = str3;
        inflate.setTag(viewHolder);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CountrySelectView.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    Object tag = view.getTag();
                    if (tag instanceof ViewHolder) {
                        CountrySelectView.this.mListener.getSelectResult(((ViewHolder) tag).code);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        if (AppSetting.f99565y) {
            inflate.setContentDescription("");
        }
        this.mListView.addHeaderView(inflate);
    }

    private void initView() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.f168365u2, (ViewGroup) null);
        this.mRootView = relativeLayout;
        this.mListView = (PinnedDividerListView) relativeLayout.findViewById(R.id.bas);
        this.mIndexView = (IndexView) this.mRootView.findViewById(R.id.djg);
    }

    @Override // android.view.View
    public View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mRootView;
    }

    public void initListView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            initListView(null, false);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        Integer num = this.mIndexMap.get(str);
        if (num != null) {
            this.mListView.setSelection(num.intValue());
        }
    }

    public void setCountrySelectListener(OnCountrySelectListener onCountrySelectListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onCountrySelectListener);
        } else {
            this.mListener = onCountrySelectListener;
        }
    }

    public void initListView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            initListView(null, z16);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
    }

    public void initListView(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.mCountryCode = str;
        initHeaderView(str, z16);
        getCountryInfo();
        this.mListView.setAdapter((ListAdapter) new CountryAdapter());
        this.mIndexView.setIndex(s_indexes, false);
        this.mIndexView.setOnIndexChangedListener(this);
    }
}
