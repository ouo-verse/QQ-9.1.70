package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ChatContentUser implements ISSOReqModel, ISSORspModel<ChatContentUser> {
    public final String clientTs;
    public final String contentData;
    public final int contentType;
    public final ImageInfo imgInfo;
    public final String parentMsgId;
    public final TransparentInfo transparent;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatContentUser() {
        this(0, r0, r0, 63);
        String str = null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("content_type", this.contentType);
        eVar.v("content_data", this.contentData);
        eVar.v("client_ts", this.clientTs);
        eVar.v("parent_msg_id", this.parentMsgId);
        if (this.transparent != null) {
            eVar.v("transparent", new e());
        }
        ImageInfo imageInfo = this.imgInfo;
        if (imageInfo != null) {
            eVar.v("img_info", imageInfo.encode());
        }
        return eVar;
    }

    public ChatContentUser(int i3, String str, String str2, String str3, TransparentInfo transparentInfo, ImageInfo imageInfo) {
        this.contentType = i3;
        this.contentData = str;
        this.clientTs = str2;
        this.parentMsgId = str3;
        this.transparent = transparentInfo;
        this.imgInfo = imageInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final ChatContentUser decode(e eVar) {
        int k3 = eVar.k("content_type", 0);
        String q16 = eVar.q("content_data", "");
        String q17 = eVar.q("client_ts", "");
        String q18 = eVar.q("parent_msg_id", "");
        TransparentInfo transparentInfo = eVar.m("transparent") != null ? new TransparentInfo() : null;
        e m3 = eVar.m("img_info");
        return new ChatContentUser(k3, q16, q17, q18, transparentInfo, m3 != null ? new ImageInfo(Utils.INSTANCE.currentBridgeModule().base64Code(m3.q("org_down_url", ""), false), m3.o("org_img_size", 0L), m3.q("thumb_down_url", ""), m3.o("thumb_img_size", 0L), m3.q("emoji_id", ""), m3.q("emoji_type", ""), m3.q("org_img_md5", ""), m3.q("thumb_img_md5", ""), m3.q("search_text", ""), m3.o("org_img_height", 0L), m3.o("org_img_width", 0L)) : null);
    }

    public /* synthetic */ ChatContentUser(int i3, String str, String str2, int i16) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : null, null, null);
    }
}
