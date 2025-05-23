package com.tenpay.sdk.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.qwallet.data.NickNameInfo;
import com.tencent.mobileqq.qwallet.hb.detail.HbDetailModule;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.ActionSheet;
import com.tenpay.QwLog;
import com.tenpay.proxy.ASProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.util.HBUtil;
import com.tenpay.sdk.util.OnGetResult;
import com.tenpay.sdk.util.QQFaceFileUtil;
import com.tenpay.util.Utils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HbListActivity extends NetBaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    public static final int HB_ICON_SIZE = 240;
    public static final int TAB_INDEX_LEFT = 0;
    public static final int TAB_INDEX_RIGHT = 1;
    public static final int TYPE_HB_LIST = 3;
    public static final int TYPE_HB_LLIST = 2;
    public static final int TYPE_HB_RLIST = 1;
    private int hb_type;
    private View list_lbtn;
    private View list_rbtn;
    private View mBtmTipsLayout;
    private TextView mCloseBtn;
    private Dialog mDialog;
    private boolean mFromout;
    private TextView mGobackBtn;
    private String mGroupid;
    protected boolean mIsBackKeyPressed;
    private CustomAdapter mLCustomAdapter;
    protected boolean mLEnd;
    private ViewGroup mLeftPage;
    private String mListid;
    private View mListltri;
    private View mListrtri;
    private Bitmap mLogoBitmap;
    private RelativeLayout mNoData;
    private CustomAdapter mRCustomAdapter;
    protected boolean mREnd;
    private ViewGroup mRightPage;
    private ViewPager mViewPager;
    protected List<View> mViews;
    private List<JSONObject> mLArray = new ArrayList();
    private List<JSONObject> mRArray = new ArrayList();
    int mYear = 2015;
    int mCurrentYear = 2015;
    private int mRemoveIndex = 0;
    private Map<String, String> mNickMap = new HashMap();
    private PagerAdapter mMpAdapter = new PagerAdapter() { // from class: com.tenpay.sdk.activity.HbListActivity.3
        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i3, Object obj) {
            ((ViewPager) view).removeView(HbListActivity.this.mViews.get(i3));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            List<View> list = HbListActivity.this.mViews;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i3) {
            ((ViewPager) view).addView(HbListActivity.this.mViews.get(i3), 0);
            return HbListActivity.this.mViews.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class CustomAdapter extends BaseAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AbsListView.OnScrollListener {
        private List<JSONObject> array;
        private ViewGroup footerlayout;
        private ViewGroup headerlayout;
        private volatile int lastItemIndex;
        private TextView mCountTv;
        private View mFooterNoteTx;
        private LayoutInflater mInflater;
        private ListView mListview;
        private volatile int mLoadingState = 0;
        private View mLoadingView;
        private ImageView mLogo;
        private int mPageType;
        private TextView mSumTv;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class ViewHolder {
            TextView amount;
            TextView name;
            ImageView pin;
            TextView state;
            TextView time;

            ViewHolder() {
            }
        }

        public CustomAdapter(Context context, int i3) {
            this.mInflater = LayoutInflater.from(context);
            this.mPageType = i3;
            if (i3 == 0) {
                this.array = HbListActivity.this.mLArray;
            } else {
                this.array = HbListActivity.this.mRArray;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<JSONObject> list = this.array;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view != null && view.getTag() != null) {
                viewHolder = (ViewHolder) view.getTag();
            } else {
                viewHolder = new ViewHolder();
                view = this.mInflater.inflate(R.layout.aez, (ViewGroup) null);
                viewHolder.name = (TextView) view.findViewById(R.id.d1k);
                viewHolder.pin = (ImageView) view.findViewById(R.id.fua);
                viewHolder.amount = (TextView) view.findViewById(R.id.f164306ro);
                viewHolder.time = (TextView) view.findViewById(R.id.jl7);
                viewHolder.state = (TextView) view.findViewById(R.id.j1q);
                view.setTag(viewHolder);
            }
            int size = this.array.size();
            if (i3 >= size) {
                i3 = size - 1;
            }
            int i16 = i3;
            JSONObject jSONObject = this.array.get(i16);
            int optInt = jSONObject.optInt(WadlProxyConsts.CHANNEL);
            if (this.mPageType == 0) {
                String optString = jSONObject.optString("send_uin");
                if (HbListActivity.this.mNickMap.containsKey(optString)) {
                    viewHolder.name.setText((CharSequence) HbListActivity.this.mNickMap.get(optString));
                } else {
                    String optString2 = jSONObject.optString("send_name");
                    if (TextUtils.isEmpty(optString2)) {
                        optString2 = optString;
                    }
                    if (((optInt != 5 && optInt != 16) || !HbListActivity.this.mUin.equals(optString)) && optInt != 2 && optInt != 4) {
                        viewHolder.name.setText(Utils.cutTextByPix(HbListActivity.this.getContext(), optString2, 136.0f, viewHolder.name.getPaint()));
                    } else {
                        viewHolder.name.setText(optString2);
                        HbListActivity.this.mNickMap.put(optString, optString2);
                    }
                }
            } else {
                viewHolder.name.setText(jSONObject.optString("desc"));
            }
            if (HBUtil.isHbForQQSpace(optInt)) {
                viewHolder.pin.setVisibility(0);
                viewHolder.pin.setImageResource(R.drawable.dxh);
            } else if (jSONObject.optInt("bus_type") == 2) {
                viewHolder.pin.setVisibility(0);
                viewHolder.pin.setImageResource(R.drawable.dx9);
            } else {
                viewHolder.pin.setVisibility(8);
            }
            if (this.mPageType == 0) {
                viewHolder.amount.setText(Utils.transformToMoney(jSONObject.optString("amount"), 0) + "\u5143");
            } else {
                viewHolder.amount.setText(Utils.transformToMoney(jSONObject.optString("total_amount"), 0) + "\u5143");
            }
            viewHolder.time.setText(jSONObject.optString(AlbumCacheData.CREATE_TIME));
            if (this.mPageType == 0) {
                viewHolder.state.setVisibility(8);
            } else {
                int optInt2 = jSONObject.optInt("state", -1);
                if (optInt2 != 1) {
                    if (optInt2 != 2) {
                        if (optInt2 != 3) {
                            if (optInt2 != 4) {
                                viewHolder.state.setText("\u5df2\u5931\u6548");
                                viewHolder.state.setTextColor(HbListActivity.this.getResources().getColor(R.color.f157670wa));
                            } else {
                                viewHolder.state.setText("\u5df2\u9000\u6b3e");
                                viewHolder.state.setTextColor(HbListActivity.this.getResources().getColor(R.color.f157670wa));
                            }
                        } else {
                            viewHolder.state.setText("\u5df2\u8fc7\u671f");
                            viewHolder.state.setTextColor(HbListActivity.this.getResources().getColor(R.color.f157670wa));
                        }
                    } else {
                        viewHolder.state.setText("\u5df2\u9886\u5b8c");
                        viewHolder.state.setTextColor(HbListActivity.this.getResources().getColor(R.color.f157670wa));
                    }
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("\u5df2\u9886\u53d6");
                    stringBuffer.append(jSONObject.optString("recv_num"));
                    stringBuffer.append("/");
                    stringBuffer.append(jSONObject.optString("total_num"));
                    stringBuffer.append("\u4e2a");
                    viewHolder.state.setText(stringBuffer.toString());
                    viewHolder.state.setTextColor(HbListActivity.this.getResources().getColor(R.color.f157604ui));
                }
            }
            EventCollector.getInstance().onListGetView(i16, view, viewGroup, getItemId(i16));
            return view;
        }

        public void initLoadingState() {
            this.mLoadingState = 0;
            this.mLoadingView.setVisibility(4);
            this.mFooterNoteTx.setVisibility(8);
        }

        public void initPageView(ViewGroup viewGroup, Context context) {
            this.mListview = (ListView) viewGroup.findViewById(R.id.eap);
            ViewGroup viewGroup2 = (ViewGroup) this.mInflater.inflate(R.layout.aey, (ViewGroup) null);
            this.headerlayout = viewGroup2;
            this.mListview.addHeaderView(viewGroup2, null, false);
            ViewGroup viewGroup3 = (ViewGroup) this.mInflater.inflate(R.layout.aex, (ViewGroup) null);
            this.footerlayout = viewGroup3;
            this.mListview.addFooterView(viewGroup3, null, false);
            this.mLogo = (ImageView) this.headerlayout.findViewById(R.id.f166149eh4);
            TextView textView = (TextView) this.headerlayout.findViewById(R.id.grv);
            this.mSumTv = (TextView) this.headerlayout.findViewById(R.id.ebf);
            this.mCountTv = (TextView) this.headerlayout.findViewById(R.id.ebi);
            String cutTextByPix = Utils.cutTextByPix(context, HbListActivity.this.mUserNick, 149.0f, textView.getPaint());
            if (this.mPageType == 0) {
                textView.setText(cutTextByPix + HbListActivity.this.getString(R.string.e7i));
            } else {
                textView.setText(cutTextByPix + HbListActivity.this.getString(R.string.e7j));
            }
            this.mListview.setOnItemClickListener(this);
            this.mListview.setOnItemLongClickListener(this);
            this.mListview.setOnScrollListener(this);
            this.mLoadingView = this.footerlayout.findViewById(R.id.je7);
            this.mFooterNoteTx = this.footerlayout.findViewById(R.id.je8);
            this.mListview.setAdapter((ListAdapter) this);
            initLoadingState();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            int i16 = i3 - 1;
            if (i16 < 0) {
                i16 = 0;
            }
            int i17 = i16;
            if (this.mPageType == 0) {
                if (i17 < HbListActivity.this.mLArray.size()) {
                    HbListActivity.this.gotoHbContent((JSONObject) HbListActivity.this.mLArray.get(i17));
                }
            } else if (i17 < HbListActivity.this.mRArray.size()) {
                HbListActivity.this.gotoHbContent((JSONObject) HbListActivity.this.mRArray.get(i17));
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i17, j3);
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemLongClickBefore(adapterView, view, i3, j3);
            int i16 = i3 - 1;
            if (i16 < 0) {
                i16 = 0;
            }
            int i17 = i16;
            HbListActivity.this.mRemoveIndex = i17;
            HbListActivity.this.showDelActionSheet();
            EventCollector.getInstance().onItemLongClick(adapterView, view, i17, j3);
            return true;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            this.lastItemIndex = ((i3 + i16) - 1) - 1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
            if (i3 == 0 && this.lastItemIndex == getCount()) {
                startLoadingData();
            }
        }

        public void setFaceImage(Bitmap bitmap) {
            ImageView imageView = this.mLogo;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }

        public void setLoadingEnd() {
            this.mLoadingState = 0;
            View view = this.mLoadingView;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        public void setNoData(boolean z16) {
            if (z16) {
                this.headerlayout.setVisibility(4);
                this.footerlayout.setVisibility(4);
            } else {
                this.headerlayout.setVisibility(0);
                this.footerlayout.setVisibility(0);
            }
        }

        public void setNoloading() {
            this.mLoadingState = 2;
            this.mLoadingView.setVisibility(4);
            this.mFooterNoteTx.setVisibility(0);
        }

        public void setSum_Count(String str, String str2) {
            TextView textView = this.mSumTv;
            if (textView != null) {
                textView.setText(str);
            }
            TextView textView2 = this.mCountTv;
            if (textView2 != null) {
                textView2.setText(str2 + "\u4e2a");
            }
        }

        public void startLoadingData() {
            if (this.mLoadingState == 0 && this.mLoadingView.getVisibility() != 0) {
                this.mLoadingState = 1;
                this.mLoadingView.setVisibility(0);
                if (this.mPageType == 0) {
                    HbListActivity hbListActivity = HbListActivity.this;
                    hbListActivity.sendHbListRequest(2, hbListActivity.mLArray.size());
                } else {
                    HbListActivity hbListActivity2 = HbListActivity.this;
                    hbListActivity2.sendHbListRequest(1, hbListActivity2.mRArray.size());
                }
            }
        }
    }

    private void check_setNodata(int i3) {
        if (i3 == 0) {
            List<JSONObject> list = this.mLArray;
            if (list != null && list.size() != 0) {
                this.mBtmTipsLayout.setVisibility(0);
                this.mLCustomAdapter.setNoData(false);
                this.mNoData.setVisibility(8);
                return;
            } else {
                this.mBtmTipsLayout.setVisibility(8);
                this.mLCustomAdapter.setNoData(true);
                this.mNoData.setVisibility(0);
                return;
            }
        }
        List<JSONObject> list2 = this.mRArray;
        if (list2 != null && list2.size() != 0) {
            this.mRCustomAdapter.setNoData(false);
            this.mNoData.setVisibility(8);
        } else {
            this.mRCustomAdapter.setNoData(true);
            this.mNoData.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteHistory(String str, String str2, String str3, int i3) {
        HashMap hashMap = new HashMap();
        if (i3 == 0) {
            hashMap.put("recvlistid", str2);
        } else if (i3 == 1) {
            hashMap.put("sendlistid", str2);
        }
        hashMap.put("uin", str);
        hashMap.put("year", str3);
        httpRequest(Cgi.URI_HB_HISTORY_DELETE, hashMap);
    }

    private void getQQName() {
        final ArrayList arrayList = new ArrayList();
        Iterator<JSONObject> it = this.mLArray.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().optString("send_uin"));
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tenpay.sdk.activity.bh
            @Override // java.lang.Runnable
            public final void run() {
                HbListActivity.this.lambda$getQQName$2(arrayList);
            }
        });
    }

    private int initCurPage(String str) {
        if (this.mHandler == null || TextUtils.isEmpty(str) || !"2".equals(str)) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getQQName$0(List list) {
        if (!isFinishing() && this.mNickMap != null && this.mLCustomAdapter != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                String uin = ((NickNameInfo) list.get(i3)).getUin();
                String nickName = ((NickNameInfo) list.get(i3)).getNickName();
                if (!TextUtils.isEmpty(uin) && !TextUtils.isEmpty(nickName)) {
                    this.mNickMap.put(uin, nickName);
                }
            }
            this.mLCustomAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$getQQName$1(final List list) {
        if (list != null && !list.isEmpty() && !isFinishing() && this.mNickMap != null && this.mLCustomAdapter != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tenpay.sdk.activity.bi
                @Override // java.lang.Runnable
                public final void run() {
                    HbListActivity.this.lambda$getQQName$0(list);
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getQQName$2(ArrayList arrayList) {
        if (isFinishing()) {
            return;
        }
        String str = this.mGroupid;
        if (str == null) {
            str = "";
        }
        QWalletNickNameServer.c(str, arrayList, new Function1() { // from class: com.tenpay.sdk.activity.bj
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$getQQName$1;
                lambda$getQQName$1 = HbListActivity.this.lambda$getQQName$1((List) obj);
                return lambda$getQQName$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelActionSheet() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("\u5220\u9664", 5);
        Dialog createActionSheet = ASProxy.createActionSheet(getContext(), getString(R.string.e5h), linkedHashMap, new ActionSheet.OnButtonClickListener() { // from class: com.tenpay.sdk.activity.HbListActivity.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:15:0x00ab A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:17:0x00ac  */
            /* JADX WARN: Type inference failed for: r7v1 */
            /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.CharSequence, java.lang.String] */
            /* JADX WARN: Type inference failed for: r7v7 */
            /* JADX WARN: Type inference failed for: r7v8 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a4 -> B:13:0x00a5). Please report as a decompilation issue!!! */
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view, int i3) {
                HbListActivity.this.mDialog.dismiss();
                if (HbListActivity.this.mViewPager != null) {
                    int currentItem = HbListActivity.this.mViewPager.getCurrentItem();
                    int i16 = 1;
                    if (currentItem == 0) {
                        try {
                        } catch (Exception e16) {
                            QLog.e(((NetBaseActivity) HbListActivity.this).TAG, i16, "", e16);
                        }
                        if (HbListActivity.this.mLArray != null && HbListActivity.this.mRemoveIndex >= 0 && HbListActivity.this.mRemoveIndex < HbListActivity.this.mLArray.size()) {
                            i16 = ((JSONObject) HbListActivity.this.mLArray.get(HbListActivity.this.mRemoveIndex)).optString("recv_listid");
                            if (TextUtils.isEmpty(i16)) {
                                return;
                            }
                            HbListActivity hbListActivity = HbListActivity.this;
                            hbListActivity.deleteHistory(hbListActivity.mUin, i16, HbListActivity.this.mYear + "", currentItem);
                            return;
                        }
                    }
                    if (currentItem == 1 && HbListActivity.this.mRArray != null && HbListActivity.this.mRemoveIndex >= 0 && HbListActivity.this.mRemoveIndex < HbListActivity.this.mRArray.size()) {
                        i16 = ((JSONObject) HbListActivity.this.mRArray.get(HbListActivity.this.mRemoveIndex)).optString("send_listid");
                        if (TextUtils.isEmpty(i16)) {
                        }
                    }
                    i16 = "";
                    if (TextUtils.isEmpty(i16)) {
                    }
                }
            }
        }, null);
        this.mDialog = createActionSheet;
        createActionSheet.show();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            QwLog.i("HbListActivity onKeyDown---- KEYCODE_BACK");
            this.mIsBackKeyPressed = true;
            this.mCloseBtn.performClick();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        if (this.mFromout) {
            return 131;
        }
        return 129;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected int getStatusBarColor() {
        return Color.parseColor("#FF2152");
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void gotoHbContent(JSONObject jSONObject) {
        try {
            Intent intent = new Intent();
            intent.putExtra("listid", jSONObject.optString("send_listid"));
            intent.putExtra(WadlProxyConsts.CHANNEL, jSONObject.optString(WadlProxyConsts.CHANNEL));
            intent.putExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.mGroupid);
            intent.putExtra(Cgi.HBList_IsFromKey, true);
            setIntentData(intent);
            HbDetailModule.k(getActivity(), intent, false);
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    public void initPageView(Context context) {
        LayoutInflater layoutInflater = getLayoutInflater();
        this.mLeftPage = (ViewGroup) layoutInflater.inflate(R.layout.f168581af0, (ViewGroup) null);
        this.mRightPage = (ViewGroup) layoutInflater.inflate(R.layout.f168581af0, (ViewGroup) null);
        this.mBtmTipsLayout = this.mLeftPage.findViewById(R.id.a6i);
        this.mLeftPage.findViewById(R.id.a4p).setOnClickListener(this);
        CustomAdapter customAdapter = new CustomAdapter(getContext(), 0);
        this.mLCustomAdapter = customAdapter;
        customAdapter.initPageView(this.mLeftPage, context);
        this.mRightPage.findViewById(R.id.l7c).setVisibility(8);
        CustomAdapter customAdapter2 = new CustomAdapter(getContext(), 1);
        this.mRCustomAdapter = customAdapter2;
        customAdapter2.initPageView(this.mRightPage, context);
        new QQFaceFileUtil(new OnGetResult() { // from class: com.tenpay.sdk.activity.HbListActivity.4
            @Override // com.tenpay.sdk.util.OnGetResult
            public void getResult(Object obj) {
                String str;
                if (!HbListActivity.this.isFinishing()) {
                    HbListActivity.this.mLogoBitmap = null;
                    if (obj == null) {
                        str = "";
                    } else {
                        str = (String) obj;
                    }
                    if (!Utils.isStringNull(str)) {
                        HbListActivity.this.mLogoBitmap = QQFaceFileUtil.getImageByPath(str, 240);
                    }
                    if (HbListActivity.this.mLogoBitmap == null) {
                        HbListActivity hbListActivity = HbListActivity.this;
                        hbListActivity.mLogoBitmap = QQFaceFileUtil.loadDefaultQQIcon(hbListActivity.getContext(), 240);
                    }
                    if (HbListActivity.this.mLogoBitmap != null) {
                        HbListActivity.this.mLCustomAdapter.setFaceImage(HbListActivity.this.mLogoBitmap);
                        HbListActivity.this.mRCustomAdapter.setFaceImage(HbListActivity.this.mLogoBitmap);
                    }
                }
            }
        }).getQQFaceImage(this.mUin, getActivity());
        ArrayList arrayList = new ArrayList();
        this.mViews = arrayList;
        arrayList.add(this.mLeftPage);
        this.mViews.add(this.mRightPage);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarDarkText() {
        return false;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        int i3 = this.hb_type;
        if (i3 == 2) {
            this.mLCustomAdapter.setLoadingEnd();
        } else if (i3 == 1) {
            this.mRCustomAdapter.setLoadingEnd();
        }
        check_setNodata(this.mViewPager.getCurrentItem());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnLeft) {
            try {
                QwLog.i("HbListActivity onClick  ivTitleBtnLeft click");
                if (this.mIsBackKeyPressed) {
                    com.tencent.mobileqq.qwallet.c.c("hongbao.record.keyback", Integer.valueOf(getProcessType()));
                } else {
                    com.tencent.mobileqq.qwallet.c.c("hongbao.record.back", Integer.valueOf(getProcessType()));
                }
                QwLog.i("HbListActivity onClick ivTitleBtnLeft after addUploadData");
                finish();
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        } else {
            if (id5 == R.id.ivTitleBtnRightText) {
                com.tencent.mobileqq.qwallet.c.c("hongbao.record.year", 109);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (this.mCurrentYear == 2015) {
                    linkedHashMap.put(this.mCurrentYear + "\u5e74", 5);
                } else {
                    for (int i3 = 0; i3 < 2; i3++) {
                        linkedHashMap.put(((this.mCurrentYear - 1) + i3) + "\u5e74", 5);
                    }
                }
                Dialog createActionSheet = ASProxy.createActionSheet(getContext(), getString(R.string.e5h), linkedHashMap, new ActionSheet.OnButtonClickListener() { // from class: com.tenpay.sdk.activity.HbListActivity.1
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public void onClick(View view2, int i16) {
                        HbListActivity.this.mDialog.dismiss();
                        com.tencent.mobileqq.qwallet.c.c("hongbao.record.changeyear", 110);
                        HbListActivity hbListActivity = HbListActivity.this;
                        hbListActivity.mYear = (hbListActivity.mCurrentYear + i16) - 1;
                        hbListActivity.mLArray.clear();
                        HbListActivity.this.mRArray.clear();
                        HbListActivity.this.mLCustomAdapter.notifyDataSetChanged();
                        HbListActivity.this.mRCustomAdapter.notifyDataSetChanged();
                        HbListActivity hbListActivity2 = HbListActivity.this;
                        hbListActivity2.mLEnd = false;
                        hbListActivity2.mREnd = false;
                        hbListActivity2.mLCustomAdapter.initLoadingState();
                        HbListActivity.this.mRCustomAdapter.initLoadingState();
                        HbListActivity.this.mGobackBtn.setText("" + HbListActivity.this.mYear + "\u5e74");
                        HbListActivity.this.sendHbListRequest(3, 0);
                    }
                }, null);
                this.mDialog = createActionSheet;
                createActionSheet.show();
            } else if (id5 == R.id.a4p) {
                com.tencent.mobileqq.qwallet.c.c("hongbao.record.usebalance", 109);
                gotoQWalletActivity(7);
                finish();
            } else if (id5 == R.id.ebh) {
                com.tencent.mobileqq.qwallet.c.c("hongbao.record.reveive", 109);
                setView(0);
                this.mViewPager.setCurrentItem(0, true);
            } else if (id5 == R.id.ebm) {
                com.tencent.mobileqq.qwallet.c.c("hongbao.record.send", 109);
                setView(1);
                this.mViewPager.setCurrentItem(1, true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i3;
        this.mFromout = getIntent().getBooleanExtra("from_out", false);
        View inflate = layoutInflater.inflate(R.layout.aew, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleBtnLeft);
        this.mCloseBtn = textView;
        textView.setOnClickListener(this);
        ((TextView) inflate.findViewById(R.id.ivTitleName)).setText(getString(R.string.dwd));
        TextView textView2 = (TextView) inflate.findViewById(R.id.ivTitleBtnRightText);
        this.mGobackBtn = textView2;
        textView2.setOnClickListener(this);
        this.mGobackBtn.setClickable(true);
        int i16 = Calendar.getInstance().get(1);
        this.mCurrentYear = i16;
        if (i16 < 2015) {
            this.mYear = 2015;
            this.mCurrentYear = 2016;
            this.mGobackBtn.setText("" + this.mYear + "\u5e74");
            this.mGobackBtn.setVisibility(0);
        } else {
            this.mYear = i16;
            this.mGobackBtn.setText("" + this.mYear + "\u5e74");
            this.mGobackBtn.setVisibility(0);
        }
        this.mNoData = (RelativeLayout) inflate.findViewById(R.id.f_i);
        View findViewById = inflate.findViewById(R.id.ebh);
        this.list_lbtn = findViewById;
        findViewById.setOnClickListener(this);
        this.mListltri = inflate.findViewById(R.id.ebj);
        View findViewById2 = inflate.findViewById(R.id.ebm);
        this.list_rbtn = findViewById2;
        findViewById2.setOnClickListener(this);
        this.mListrtri = inflate.findViewById(R.id.ebo);
        initPageView(getContext());
        Intent intent = getIntent();
        if (intent != null) {
            this.mGroupid = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
            this.mListid = intent.getStringExtra("listid");
            i3 = initCurPage(intent.getStringExtra("tab_index"));
        } else {
            i3 = 0;
        }
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.kmf);
        this.mViewPager = viewPager;
        viewPager.setAdapter(this.mMpAdapter);
        this.mMpAdapter.notifyDataSetChanged();
        this.mViewPager.setCurrentItem(i3);
        setView(i3);
        this.mViewPager.setOnPageChangeListener(this);
        sendHbListRequest(3, 0);
        com.tencent.mobileqq.qwallet.c.c("redpackets.closed.show", Integer.valueOf(getProcessType()));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Bitmap bitmap = this.mLogoBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mLogoBitmap.recycle();
        }
        super.onDestroy();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        setView(i3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        ViewPager viewPager;
        List<JSONObject> list;
        int i3;
        List<JSONObject> list2;
        int i16;
        int i17;
        super.onSuccess(str, jSONObject);
        if (Cgi.URI_HB_LIST.equals(str) && ((i17 = this.hb_type) == 3 || i17 == 2 || i17 == 1)) {
            if (i17 == 2) {
                this.mLCustomAdapter.setLoadingEnd();
            } else if (i17 == 1) {
                this.mRCustomAdapter.setLoadingEnd();
            }
            int optInt = jSONObject.optInt("limit");
            JSONArray optJSONArray = jSONObject.optJSONArray("recv_array");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                if (length < optInt) {
                    this.mLEnd = true;
                    this.mLCustomAdapter.setNoloading();
                }
                for (int i18 = 0; i18 < length; i18++) {
                    this.mLArray.add(optJSONArray.optJSONObject(i18));
                }
            } else {
                int i19 = this.hb_type;
                if (i19 == 3 || i19 == 2) {
                    this.mLEnd = true;
                    this.mLCustomAdapter.setNoloading();
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("send_array");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                if (length2 < optInt) {
                    this.mREnd = true;
                    this.mRCustomAdapter.setNoloading();
                }
                for (int i26 = 0; i26 < length2; i26++) {
                    this.mRArray.add(optJSONArray2.optJSONObject(i26));
                }
            } else {
                int i27 = this.hb_type;
                if (i27 == 3 || i27 == 1) {
                    this.mREnd = true;
                    this.mRCustomAdapter.setNoloading();
                }
            }
            if (this.hb_type == 3) {
                this.mLCustomAdapter.setSum_Count(Utils.transformToMoney(jSONObject.optString("total_recv_amount"), 0), jSONObject.optString("total_recv_num"));
                this.mRCustomAdapter.setSum_Count(Utils.transformToMoney(jSONObject.optString("total_send_amount"), 0), jSONObject.optString("total_send_num"));
            }
            check_setNodata(this.mViewPager.getCurrentItem());
            this.mLCustomAdapter.notifyDataSetChanged();
            this.mRCustomAdapter.notifyDataSetChanged();
            getQQName();
            return;
        }
        if (!str.equals(Cgi.URI_HB_HISTORY_DELETE) || (viewPager = this.mViewPager) == null) {
            return;
        }
        int currentItem = viewPager.getCurrentItem();
        if (currentItem == 0 && (list2 = this.mLArray) != null && (i16 = this.mRemoveIndex) >= 0 && i16 < list2.size()) {
            this.mLArray.remove(this.mRemoveIndex);
            this.mLCustomAdapter.notifyDataSetChanged();
            this.mLCustomAdapter.startLoadingData();
        }
        if (currentItem == 1 && (list = this.mRArray) != null && (i3 = this.mRemoveIndex) >= 0 && i3 < list.size()) {
            this.mRArray.remove(this.mRemoveIndex);
            this.mRCustomAdapter.notifyDataSetChanged();
            this.mRCustomAdapter.startLoadingData();
        }
        check_setNodata(this.mViewPager.getCurrentItem());
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void sendHbListRequest(int i3, int i16) {
        this.hb_type = i3;
        HashMap hashMap = new HashMap();
        hashMap.put("offset", i16 + "");
        hashMap.put("type", i3 + "");
        hashMap.put("year", this.mYear + "");
        hashMap.put("uin", this.mUin);
        if (3 != i3) {
            httpRequest(Cgi.URI_HB_LIST, hashMap);
        } else {
            NetSender.with(getContext(), Cgi.URI_HB_LIST, hashMap, this.mUin).tokenID(this.mPayTokenId).comeFrom(Integer.toString(this.mComeFrom)).request(this);
        }
    }

    public void setView(int i3) {
        if (i3 == 0) {
            this.list_lbtn.setSelected(true);
            this.list_rbtn.setSelected(false);
            this.mListltri.setVisibility(0);
            this.mListrtri.setVisibility(4);
            check_setNodata(0);
            return;
        }
        this.list_lbtn.setSelected(false);
        this.list_rbtn.setSelected(true);
        this.mListltri.setVisibility(4);
        this.mListrtri.setVisibility(0);
        check_setNodata(1);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}
