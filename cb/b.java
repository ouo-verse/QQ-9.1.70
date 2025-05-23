package cb;

import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b+\u0010,R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\b\u0019\u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010&\u001a\u0004\b\u0012\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcb/b;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "mediaId", "", "b", "I", "d", "()I", "k", "(I)V", "itemType", "c", "g", DomainData.DOMAIN_NAME, "mediaPos", h.F, "curTimeMediaSize", "", "e", "J", "()J", "i", "(J)V", "curTimeStamp", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "l", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;)V", "mediaData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "j", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;)V", "event", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mediaId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int itemType = 1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mediaPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curTimeMediaSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long curTimeStamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonPhotoInfo mediaData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private CommonStTimeLineEvent event;

    /* renamed from: a, reason: from getter */
    public final int getCurTimeMediaSize() {
        return this.curTimeMediaSize;
    }

    /* renamed from: b, reason: from getter */
    public final long getCurTimeStamp() {
        return this.curTimeStamp;
    }

    /* renamed from: c, reason: from getter */
    public final CommonStTimeLineEvent getEvent() {
        return this.event;
    }

    /* renamed from: d, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    /* renamed from: e, reason: from getter */
    public final CommonPhotoInfo getMediaData() {
        return this.mediaData;
    }

    /* renamed from: f, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    /* renamed from: g, reason: from getter */
    public final int getMediaPos() {
        return this.mediaPos;
    }

    public final void h(int i3) {
        this.curTimeMediaSize = i3;
    }

    public final void i(long j3) {
        this.curTimeStamp = j3;
    }

    public final void j(CommonStTimeLineEvent commonStTimeLineEvent) {
        this.event = commonStTimeLineEvent;
    }

    public final void k(int i3) {
        this.itemType = i3;
    }

    public final void l(CommonPhotoInfo commonPhotoInfo) {
        this.mediaData = commonPhotoInfo;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaId = str;
    }

    public final void n(int i3) {
        this.mediaPos = i3;
    }
}
