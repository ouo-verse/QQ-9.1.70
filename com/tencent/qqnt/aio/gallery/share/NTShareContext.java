package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\bF\u0010GJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0015\u0010\u001dR\u0019\u0010#\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b!\u0010\"R0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u00104\u001a\u0004\b-\u00105\"\u0004\b6\u00107R$\u0010?\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0019\u0010B\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010@\u001a\u0004\b\u001b\u0010AR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010@\u001a\u0004\b\n\u0010A\"\u0004\bC\u0010D\u00a8\u0006H"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/s;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "b", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;", "j", "()Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;", "shareManger", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "c", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "e", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "layerItemInfo", "Lcom/tencent/mobileqq/richmediabrowser/AIOBrowserBaseData;", "d", "Lcom/tencent/mobileqq/richmediabrowser/AIOBrowserBaseData;", "()Lcom/tencent/mobileqq/richmediabrowser/AIOBrowserBaseData;", "aioLayerData", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", tl.h.F, "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lkotlin/Pair;", "", "f", "Lkotlin/Pair;", "()Lkotlin/Pair;", "setMainAndSubId", "(Lkotlin/Pair;)V", "mainAndSubId", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "g", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "i", "()Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "setProvider", "(Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;)V", "provider", "I", "()I", "setMediaType", "(I)V", "mediaType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "k", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "setTargetElement", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;)V", "targetElement", "Ljava/lang/String;", "()Ljava/lang/String;", "existSaveOrEditPath", "l", "(Ljava/lang/String;)V", "actionId", "<init>", "(Landroid/app/Activity;Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager;Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;Lcom/tencent/mobileqq/richmediabrowser/AIOBrowserBaseData;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqnt.aio.gallery.share.s, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class NTShareContext {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final NTShareActionManager shareManger;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final RFWLayerItemMediaInfo layerItemInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final AIOBrowserBaseData aioLayerData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final MsgRecord msgRecord;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Pair<Long, Integer> mainAndSubId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.aio.adapter.richmedia.provider.h provider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mediaType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MsgElement targetElement;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final String existSaveOrEditPath;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String actionId;

    public NTShareContext(Activity activity, NTShareActionManager shareManger, RFWLayerItemMediaInfo layerItemInfo, AIOBrowserBaseData aioLayerData, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareManger, "shareManger");
        Intrinsics.checkNotNullParameter(layerItemInfo, "layerItemInfo");
        Intrinsics.checkNotNullParameter(aioLayerData, "aioLayerData");
        this.activity = activity;
        this.shareManger = shareManger;
        this.layerItemInfo = layerItemInfo;
        this.aioLayerData = aioLayerData;
        this.msgRecord = msgRecord;
        this.actionId = "";
        Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.h.f350002a.a(layerItemInfo);
        this.mainAndSubId = a16;
        if (msgRecord != null && a16 != null) {
            this.provider = ru3.c.e(ru3.c.f432503a, msgRecord, null, 2, null);
            Pair<Long, Integer> pair = this.mainAndSubId;
            Intrinsics.checkNotNull(pair);
            this.mediaType = com.tencent.qqnt.aio.gallery.e.a(msgRecord, pair.getSecond().intValue());
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            Pair<Long, Integer> pair2 = this.mainAndSubId;
            Intrinsics.checkNotNull(pair2);
            this.targetElement = arrayList.get(pair2.getSecond().intValue());
        }
        String existSaveOrEditPath = layerItemInfo.getExistSaveOrEditPath();
        this.existSaveOrEditPath = existSaveOrEditPath;
        QLog.i("NTShareContext", 1, "mainAndSubId:" + this.mainAndSubId + " existSaveOrEditPath:" + existSaveOrEditPath);
    }

    /* renamed from: a, reason: from getter */
    public final String getActionId() {
        return this.actionId;
    }

    /* renamed from: b, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* renamed from: c, reason: from getter */
    public final AIOBrowserBaseData getAioLayerData() {
        return this.aioLayerData;
    }

    /* renamed from: d, reason: from getter */
    public final String getExistSaveOrEditPath() {
        return this.existSaveOrEditPath;
    }

    /* renamed from: e, reason: from getter */
    public final RFWLayerItemMediaInfo getLayerItemInfo() {
        return this.layerItemInfo;
    }

    public final Pair<Long, Integer> f() {
        return this.mainAndSubId;
    }

    /* renamed from: g, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    /* renamed from: h, reason: from getter */
    public final MsgRecord getMsgRecord() {
        return this.msgRecord;
    }

    public int hashCode() {
        int hashCode = ((((((this.activity.hashCode() * 31) + this.shareManger.hashCode()) * 31) + this.layerItemInfo.hashCode()) * 31) + this.aioLayerData.hashCode()) * 31;
        MsgRecord msgRecord = this.msgRecord;
        return hashCode + (msgRecord == null ? 0 : msgRecord.hashCode());
    }

    /* renamed from: i, reason: from getter */
    public final com.tencent.qqnt.aio.adapter.richmedia.provider.h getProvider() {
        return this.provider;
    }

    /* renamed from: j, reason: from getter */
    public final NTShareActionManager getShareManger() {
        return this.shareManger;
    }

    /* renamed from: k, reason: from getter */
    public final MsgElement getTargetElement() {
        return this.targetElement;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionId = str;
    }

    public String toString() {
        return "NTShareContext(activity=" + this.activity + ", shareManger=" + this.shareManger + ", layerItemInfo=" + this.layerItemInfo + ", aioLayerData=" + this.aioLayerData + ", msgRecord=" + this.msgRecord + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NTShareContext)) {
            return false;
        }
        NTShareContext nTShareContext = (NTShareContext) other;
        return Intrinsics.areEqual(this.activity, nTShareContext.activity) && Intrinsics.areEqual(this.shareManger, nTShareContext.shareManger) && Intrinsics.areEqual(this.layerItemInfo, nTShareContext.layerItemInfo) && Intrinsics.areEqual(this.aioLayerData, nTShareContext.aioLayerData) && Intrinsics.areEqual(this.msgRecord, nTShareContext.msgRecord);
    }
}
