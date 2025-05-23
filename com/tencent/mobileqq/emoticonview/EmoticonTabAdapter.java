package com.tencent.mobileqq.emoticonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVas04586Report;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import common.config.service.QzoneConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonTabAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    public static LruCache<String, URL> urlCache;
    IEmoticonMainPanelApp app;
    private boolean inGuildLiveRoom;
    private int mBusinessType;
    protected Context mContext;
    List<EmoticonTabItem> mData;
    private Drawable mGifEntranceIconDrawable;
    LayoutInflater mInflater;
    Drawable mItemNormalDrawable;
    Drawable mItemSelectedDrawable;
    Drawable mNormalDrawable;
    private com.tencent.mobileqq.i mPanelInjectionInfoManager;
    Drawable mSelectedDrawable;
    private boolean mStyleChange;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class EmoticonTabItem {
        static IPatchRedirector $redirector_;
        boolean completed;
        String description;
        String epId;
        int subType;
        int type;

        public EmoticonTabItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "type:" + this.type + ", subType:" + this.subType + ", epId:" + this.epId + ", description:" + this.description;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ViewHolder {
        static IPatchRedirector $redirector_;
        View emoContainer;
        ImageView redImage;
        URLImageView tabImage;

        public ViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonTabAdapter.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49342);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            urlCache = new LruCache<>(50);
        }
    }

    public EmoticonTabAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, com.tencent.mobileqq.i iVar, Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iVar, context, Integer.valueOf(i3));
            return;
        }
        this.mGifEntranceIconDrawable = null;
        this.inGuildLiveRoom = false;
        this.app = iEmoticonMainPanelApp;
        this.mContext = context;
        this.mPanelInjectionInfoManager = iVar;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mData = new ArrayList();
        this.mNormalDrawable = context.getResources().getDrawable(R.drawable.c0q);
        this.mSelectedDrawable = context.getResources().getDrawable(R.drawable.c0r);
        setSelectBgSkinDrawable();
        this.mItemNormalDrawable = new ColorDrawable(0);
        this.mBusinessType = i3;
    }

    public static URL generateTabUrl(String str, boolean z16) {
        URL url;
        URL url2 = null;
        if (str == null) {
            return null;
        }
        try {
            url = urlCache.get(str + "_" + z16);
        } catch (MalformedURLException e16) {
            e = e16;
        }
        if (url != null) {
            return url;
        }
        try {
            url2 = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_EMOTICON_TAB, str + "_" + z16);
        } catch (MalformedURLException e17) {
            e = e17;
            url2 = url;
            QLog.e("EmoticonTabAdapter", 2, "generateTabUrl error = " + e.getMessage());
            urlCache.put(str, url2);
            return url2;
        }
        urlCache.put(str, url2);
        return url2;
    }

    private void reportAITabExposure() {
        com.tencent.mobileqq.aio.utils.b.q(EmotionDaTongReportUtil.EM_BAS_AI_EXPRESSION, null);
    }

    private void setEmoMallDTReport(View view) {
        if (this.mBusinessType != 0) {
            return;
        }
        VideoReport.setElementId(view, EmotionReportDtImpl.EM_AIO_STICKERS_MALL_BELOW_TEXTBOX);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(view, EmotionReportDtImpl.EM_AIO_STICKERS_MALL_BELOW_TEXTBOX);
    }

    private void setEmoSettingDTReport(View view) {
        if (this.mBusinessType != 0) {
            return;
        }
        VideoReport.setElementId(view, EmotionReportDtImpl.EM_AIO_SETTING_BELOW_TEXTBOX);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(view, EmotionReportDtImpl.EM_AIO_SETTING_BELOW_TEXTBOX);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.mData.size()) {
            return this.mData.get(i3);
        }
        QLog.e("EmoticonTabAdapter", 1, "getItem error");
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        return i3;
    }

    public Drawable getTabDrawable(EmoticonTabItem emoticonTabItem) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this, (Object) emoticonTabItem);
        }
        URL generateTabUrl = generateTabUrl(emoticonTabItem.epId, emoticonTabItem.completed);
        if (generateTabUrl != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = this.mNormalDrawable;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            if (10 == emoticonTabItem.type) {
                z16 = true;
            } else {
                z16 = false;
            }
            obtain.mExtraInfo = Boolean.valueOf(z16);
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonTabAdapter", 2, "getTabDrawable, completed = " + emoticonTabItem.completed + ", epId = " + emoticonTabItem.epId);
            }
            URLDrawable drawable2 = URLDrawable.getDrawable(generateTabUrl, obtain);
            if (drawable2.getStatus() == 2) {
                drawable2.restartDownload();
                return drawable2;
            }
            return drawable2;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        EmoticonManagerServiceProxy emoticonManagerServiceProxy;
        EmoticonManagerServiceProxy emoticonManagerServiceProxy2;
        View view3;
        View view4;
        EmotionInjectionInfo b16;
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view3 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view4 = view;
        } else {
            Drawable drawable2 = null;
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = HorizontalListViewEx.consumeView();
                if (view2 == null) {
                    view2 = this.mInflater.inflate(R.layout.h86, viewGroup, false);
                }
                viewHolder.tabImage = (URLImageView) view2.findViewById(R.id.tabView);
                viewHolder.redImage = (ImageView) view2.findViewById(R.id.f166773i54);
                viewHolder.emoContainer = view2.findViewById(R.id.ezu);
                view2.setTag(viewHolder);
                if (this.mStyleChange) {
                    view2.setBackgroundDrawable(null);
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    if (this.inGuildLiveRoom) {
                        this.mItemSelectedDrawable = ViewUtils.getShapeDrawable(Color.parseColor("#2F3033"), ViewUtils.dip2px(18.0f));
                    }
                    stateListDrawable.addState(new int[]{android.R.attr.state_selected}, this.mItemSelectedDrawable);
                    stateListDrawable.addState(new int[0], this.mItemNormalDrawable);
                    viewHolder.emoContainer.setBackgroundDrawable(stateListDrawable);
                } else {
                    viewHolder.emoContainer.setBackgroundDrawable(null);
                    view2.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.l0f));
                }
            } else {
                viewHolder = (ViewHolder) view.getTag();
                view2 = view;
            }
            ViewHolder viewHolder2 = viewHolder;
            EmoticonTabItem emoticonTabItem = (EmoticonTabItem) getItem(i3);
            if (emoticonTabItem == null) {
                QLog.e("EmoticonTabAdapter", 1, "getView item is null ,position = " + i3);
                view3 = null;
                view4 = view2;
            } else {
                if (emoticonTabItem.type == 6) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("touin", this.app.getCurrentUin());
                        jSONObject.put("emoji_id", emoticonTabItem.epId);
                        ((IVas04586Report) QRoute.api(IVas04586Report.class)).reportAction("DressVip", "pg_aio", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "icon", "", "4", 101, 0, 0, "", jSONObject.toString(), "");
                    } catch (Exception e16) {
                        QLog.i("EmoticonTabAdapter", 1, "report exception: " + e16.getMessage());
                    }
                }
                viewHolder2.redImage.setVisibility(8);
                viewHolder2.tabImage.setTag(null);
                int i17 = emoticonTabItem.type;
                switch (i17) {
                    case 4:
                        IEmoticonMainPanelApp iEmoticonMainPanelApp = this.app;
                        if (iEmoticonMainPanelApp != null && (emoticonManagerServiceProxy = (EmoticonManagerServiceProxy) iEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)) != null) {
                            boolean isShowFavTabRedPoint = emoticonManagerServiceProxy.isShowFavTabRedPoint(this.mBusinessType);
                            ImageView imageView = viewHolder2.redImage;
                            if (!isShowFavTabRedPoint) {
                                i16 = 8;
                            }
                            imageView.setVisibility(i16);
                        }
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.j6j);
                        break;
                    case 5:
                    case 15:
                    case 16:
                    case 18:
                    default:
                        com.tencent.mobileqq.i iVar = this.mPanelInjectionInfoManager;
                        if (iVar != null && (b16 = iVar.b(i17)) != null) {
                            if (b16.iconResId > 0) {
                                if (b16.iconColorResId != 0) {
                                    drawable = BaseImageUtil.maskDrawableByColor(ResourcesCompat.getDrawable(this.mContext.getResources(), b16.iconResId, null), this.mContext.getColor(b16.iconColorResId));
                                } else {
                                    drawable = this.mContext.getResources().getDrawable(b16.iconResId);
                                }
                                drawable2 = drawable;
                            }
                            IEmotionTabCreateListener iEmotionTabCreateListener = b16.emotionTabListener;
                            if (iEmotionTabCreateListener != null) {
                                iEmotionTabCreateListener.onCreateTabView(view2, viewHolder2.tabImage, viewHolder2.redImage, i3);
                                break;
                            }
                        }
                        break;
                    case 6:
                    case 10:
                        Drawable tabDrawable = getTabDrawable(emoticonTabItem);
                        Drawable drawable3 = tabDrawable;
                        if (tabDrawable == null) {
                            StateListDrawable stateListDrawable2 = new StateListDrawable();
                            stateListDrawable2.addState(new int[]{android.R.attr.state_selected}, this.mSelectedDrawable);
                            stateListDrawable2.addState(new int[0], this.mNormalDrawable);
                            ThreadManagerV2.post(new Runnable(emoticonTabItem) { // from class: com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ EmoticonTabItem val$item;

                                {
                                    this.val$item = emoticonTabItem;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonTabAdapter.this, (Object) emoticonTabItem);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.w("EmoticonTabAdapter", 2, "package lossY");
                                    }
                                    EmoticonManagerServiceProxy emoticonManagerServiceProxy3 = (EmoticonManagerServiceProxy) EmoticonTabAdapter.this.app.getRuntimeService(IEmoticonManagerService.class);
                                    EmoticonPackage syncFindEmoticonPackageById = emoticonManagerServiceProxy3.syncFindEmoticonPackageById(this.val$item.epId);
                                    if (syncFindEmoticonPackageById != null) {
                                        syncFindEmoticonPackageById.status = 0;
                                        emoticonManagerServiceProxy3.saveEmoticonPackage(syncFindEmoticonPackageById);
                                    }
                                }
                            }, 5, null, false);
                            drawable3 = stateListDrawable2;
                        }
                        drawable2 = drawable3;
                        break;
                    case 7:
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.j6g);
                        break;
                    case 8:
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.fod);
                        IEmoticonMainPanelApp iEmoticonMainPanelApp2 = this.app;
                        if (iEmoticonMainPanelApp2 != null && (emoticonManagerServiceProxy2 = (EmoticonManagerServiceProxy) iEmoticonMainPanelApp2.getRuntimeService(IEmoticonManagerService.class)) != null && emoticonManagerServiceProxy2.isShowRecommendTabRedPoint(this.mBusinessType)) {
                            viewHolder2.redImage.setVisibility(0);
                            this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", true).apply();
                            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "j_redshow", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                            break;
                        }
                        break;
                    case 9:
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.fo6);
                        break;
                    case 11:
                        if (((CameraEmoRoamingManagerServiceProxy) this.app.getRuntimeService(ICameraEmoRoamingManagerService.class)).getIsNeedShowGuide()) {
                            viewHolder2.redImage.setVisibility(0);
                        }
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.hkw);
                        break;
                    case 12:
                        drawable2 = this.mGifEntranceIconDrawable;
                        if (drawable2 == null) {
                            drawable2 = this.mContext.getResources().getDrawable(R.drawable.j6h);
                            break;
                        }
                        break;
                    case 13:
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.qui_chat_add_selector_01);
                        setEmoMallDTReport(viewHolder2.emoContainer);
                        break;
                    case 14:
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.l0u);
                        setEmoSettingDTReport(viewHolder2.emoContainer);
                        break;
                    case 17:
                        com.tencent.mobileqq.i iVar2 = this.mPanelInjectionInfoManager;
                        if (iVar2 != null) {
                            EmotionInjectionInfo b17 = iVar2.b(17);
                            viewHolder2.tabImage.setTag(17);
                            if (b17 != null) {
                                if (b17.iconResId > 0) {
                                    drawable2 = this.mContext.getResources().getDrawable(b17.iconResId);
                                }
                                IEmotionTabCreateListener iEmotionTabCreateListener2 = b17.emotionTabListener;
                                if (iEmotionTabCreateListener2 != null) {
                                    iEmotionTabCreateListener2.onCreateTabView(view2, viewHolder2.tabImage, viewHolder2.redImage, i3);
                                    break;
                                }
                            }
                        }
                        break;
                    case 19:
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.j6n);
                        break;
                    case 20:
                        drawable2 = this.mContext.getResources().getDrawable(R.drawable.j6f);
                        reportAITabExposure();
                        break;
                }
                if (drawable2 != null) {
                    viewHolder2.tabImage.setImageDrawable(drawable2);
                }
                view3 = view2;
                view4 = view3;
            }
        }
        EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
        return view3;
    }

    public void setAIOShowStyleChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.mStyleChange = z16;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setGifEntranceIcon(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mGifEntranceIconDrawable = this.mContext.getResources().getDrawable(R.drawable.j6h);
        }
    }

    public void setInGuildLiveRoom(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.inGuildLiveRoom = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectBgSkinDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mItemSelectedDrawable = ViewUtils.getShapeDrawable(this.mContext.getResources().getColor(R.color.qui_common_fill_standard_primary), ViewUtils.dip2px(9.0f));
        }
    }

    public void updateData(List<EmoticonTabItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
    }
}
