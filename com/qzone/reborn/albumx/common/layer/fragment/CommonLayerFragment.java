package com.qzone.reborn.albumx.common.layer.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.reborn.layer.part.cq;
import com.qzone.reborn.layer.part.cr;
import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.gallery.QQLayerFragment;
import fo.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import o9.c;
import qj.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 *2\u00020\u0001:\u0002+,B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH$J\b\u0010\u0016\u001a\u00020\u0015H$J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001a\u0010\u001b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H\u0016J\u0016\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016R\"\u0010$\u001a\u00020\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "", "ph", "registerDaTongReportPageId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "Lcom/tencent/biz/richframework/part/Part;", "getMediaStrategyPart", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onResume", "", "assembleParts", "rh", "sh", "", "th", "", "getDaTongPageId", "", "", "getChildDaTongPageParams", "getChildDaTongDynamicParams", "Lo9/c;", BdhLogUtil.LogTag.Tag_Conn, "Lo9/c;", "qh", "()Lo9/c;", "setInitBean", "(Lo9/c;)V", "initBean", "D", "Landroid/view/View;", "contentView", "<init>", "()V", "E", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonLayerFragment extends QQLayerFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private c initBean = new c();

    /* renamed from: D, reason: from kotlin metadata */
    private View contentView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Ljava/lang/ref/WeakReference;", "Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "mWeakReference", "baseLayerFragment", "<init>", "(Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<CommonLayerFragment> mWeakReference;

        public b(CommonLayerFragment baseLayerFragment) {
            Intrinsics.checkNotNullParameter(baseLayerFragment, "baseLayerFragment");
            this.mWeakReference = new WeakReference<>(baseLayerFragment);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            Map<String, Object> childDaTongDynamicParams;
            Intrinsics.checkNotNullParameter(event, "event");
            CommonLayerFragment commonLayerFragment = this.mWeakReference.get();
            return (commonLayerFragment == null || (childDaTongDynamicParams = commonLayerFragment.getChildDaTongDynamicParams()) == null) ? new LinkedHashMap() : childDaTongDynamicParams;
        }
    }

    private final void ph() {
        this.initBean.b(th());
    }

    private final void registerDaTongReportPageId() {
        String str;
        if (this.contentView == null) {
            RFWLog.i("QZoneBaseLayerFragment", RFWLog.USR, "reportDaTongRegister  mContentView == null , subPage: " + getLogTag());
            return;
        }
        if (!TextUtils.isEmpty(getDaTongPageId())) {
            str = getDaTongPageId();
        } else {
            str = "qzone_base_pageId";
        }
        VideoReport.setPageId(this.contentView, str);
        VideoReport.setPageParams(this.contentView, new a().d("QZoneBaseLayerFragment", getChildDaTongPageParams()));
        VideoReport.setEventDynamicParams(this.contentView, new b(this));
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(0, rh());
        arrayList.add(new cs());
        arrayList.add(new cr());
        Part sh5 = sh();
        if (sh5 != null) {
            arrayList.add(sh5);
        }
        return arrayList;
    }

    public Map<String, Object> getChildDaTongDynamicParams() {
        l lVar = (l) PartFragmentIOCKt.getIocInterface(this, l.class);
        if (lVar == null) {
            return null;
        }
        return lVar.D6();
    }

    public Map<String, Object> getChildDaTongPageParams() {
        return null;
    }

    public String getDaTongPageId() {
        return "";
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public Part getMediaStrategyPart() {
        return new cq();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ph();
        VideoReport.addToDetectionWhitelist(getActivity());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View f16 = jm.b.f410600a.f(getActivity(), getContentLayoutId(), false);
        this.contentView = f16;
        if (f16 == null) {
            this.contentView = inflater.inflate(getContentLayoutId(), container, false);
        }
        return this.contentView;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        registerDaTongReportPageId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: qh, reason: from getter */
    public final c getInitBean() {
        return this.initBean;
    }

    protected Part rh() {
        return new y();
    }

    protected abstract Part sh();

    protected abstract int th();
}
