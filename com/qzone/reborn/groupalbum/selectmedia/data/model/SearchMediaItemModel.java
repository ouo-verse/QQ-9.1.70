package com.qzone.reborn.groupalbum.selectmedia.data.model;

import com.qzone.reborn.groupalbum.selectmedia.util.PicSize;
import com.qzone.reborn.groupalbum.selectmedia.util.a;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.util.string.c;
import com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import zi.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\b\u0018\u0000 \u00132\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b<\u0010=J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010%\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R'\u00106\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b\u001d\u00105R\u0014\u00108\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010 R\u0014\u00109\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u0010 R\u0011\u0010;\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b:\u0010 \u00a8\u0006>"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaItemModel;", "Lzi/b;", "", "Lyi/e;", "", ReportConstant.COSTREPORT_PREFIX, "", "p", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "k", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "g", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "", "f", "J", h.F, "()J", "elementId", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", QQBrowserActivity.KEY_MSG_TYPE, "Z", "i", "()Z", "t", "(Z)V", "expire", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "thumbPath", "Lkotlin/Pair;", "j", "Lkotlin/Lazy;", "()Lkotlin/Pair;", "downLoadReq", "a", "msgTime", "msgId", "l", "msgSeq", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class SearchMediaItemModel extends b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final MsgRecord msgRecord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final MsgElement element;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long elementId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int msgType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean expire;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String thumbPath;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy downLoadReq;

    public SearchMediaItemModel(MsgRecord msgRecord, MsgElement element) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(element, "element");
        this.msgRecord = msgRecord;
        this.element = element;
        this.elementId = element.elementId;
        this.msgType = msgRecord.msgType;
        this.expire = a.k(element);
        this.thumbPath = a.i(element, PicSize.PIC_DOWNLOAD_THUMB);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel$downLoadReq$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pair<? extends Integer, ? extends Integer> invoke() {
                return a.f(SearchMediaItemModel.this.getElement(), PicSize.PIC_DOWNLOAD_THUMB);
            }
        });
        this.downLoadReq = lazy;
    }

    @Override // yi.e
    /* renamed from: a */
    public long getMsgTime() {
        return this.msgRecord.msgTime;
    }

    public final Pair<Integer, Integer> f() {
        return (Pair) this.downLoadReq.getValue();
    }

    /* renamed from: g, reason: from getter */
    public final MsgElement getElement() {
        return this.element;
    }

    /* renamed from: h, reason: from getter */
    public final long getElementId() {
        return this.elementId;
    }

    public int hashCode() {
        return (this.msgRecord.hashCode() * 31) + this.element.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getExpire() {
        return this.expire;
    }

    public long j() {
        return this.msgRecord.msgId;
    }

    /* renamed from: k, reason: from getter */
    public final MsgRecord getMsgRecord() {
        return this.msgRecord;
    }

    public final long l() {
        return this.msgRecord.msgSeq;
    }

    /* renamed from: m, reason: from getter */
    public final int getMsgType() {
        return this.msgType;
    }

    /* renamed from: n, reason: from getter */
    public final String getThumbPath() {
        return this.thumbPath;
    }

    public final String o() {
        VideoElement videoElement;
        if (p() || (videoElement = this.element.videoElement) == null) {
            return null;
        }
        return c.f362990a.a(videoElement.fileTime);
    }

    public final boolean p() {
        return this.msgRecord.msgType == 2 && this.element.elementType == 2;
    }

    public final boolean q() {
        return (this.expire || ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).invalidMedia(this.msgRecord)) ? false : true;
    }

    public final boolean r() {
        return this.msgRecord.msgType == 7 && this.element.elementType == 5;
    }

    public final String s() {
        return a.i(this.element, PicSize.PIC_DOWNLOAD_ORI);
    }

    public final void t(boolean z16) {
        this.expire = z16;
    }

    public String toString() {
        return "SearchMediaItemModel(msgRecord=" + this.msgRecord + ", element=" + this.element + ")";
    }

    public final void u(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thumbPath = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchMediaItemModel)) {
            return false;
        }
        SearchMediaItemModel searchMediaItemModel = (SearchMediaItemModel) other;
        return Intrinsics.areEqual(this.msgRecord, searchMediaItemModel.msgRecord) && Intrinsics.areEqual(this.element, searchMediaItemModel.element);
    }
}
