package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ChatContentBot implements ISSOReqModel, ISSORspModel<ChatContentBot> {
    public final String algVersion;
    public final String contentData;
    public final int contentType;
    public final String conversationId;
    public final ImageInfo imgInfo;
    public final String serverTs;
    public final TransparentInfo transparent;

    public ChatContentBot() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("content_type", this.contentType);
        eVar.v("content_data", this.contentData);
        eVar.v("server_ts", this.serverTs);
        eVar.v("conversation_id", this.conversationId);
        if (this.transparent != null) {
            eVar.v("transparent", new e());
        }
        ImageInfo imageInfo = this.imgInfo;
        if (imageInfo != null) {
            eVar.v("img_info", imageInfo.encode());
        }
        eVar.v("alg_version", this.algVersion);
        return eVar;
    }

    public ChatContentBot(int i3, String str, String str2, String str3, TransparentInfo transparentInfo, ImageInfo imageInfo, String str4) {
        this.contentType = i3;
        this.contentData = str;
        this.serverTs = str2;
        this.conversationId = str3;
        this.transparent = transparentInfo;
        this.imgInfo = imageInfo;
        this.algVersion = str4;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final ChatContentBot decode(e eVar) {
        int k3 = eVar.k("content_type", 0);
        String q16 = eVar.q("content_data", "");
        String q17 = eVar.q("server_ts", "");
        String q18 = eVar.q("conversation_id", "");
        TransparentInfo transparentInfo = eVar.m("transparent") != null ? new TransparentInfo() : null;
        e m3 = eVar.m("img_info");
        return new ChatContentBot(k3, q16, q17, q18, transparentInfo, m3 != null ? new ImageInfo(Utils.INSTANCE.currentBridgeModule().base64Code(m3.q("org_down_url", ""), false), m3.o("org_img_size", 0L), m3.q("thumb_down_url", ""), m3.o("thumb_img_size", 0L), m3.q("emoji_id", ""), m3.q("emoji_type", ""), m3.q("org_img_md5", ""), m3.q("thumb_img_md5", ""), m3.q("search_text", ""), m3.o("org_img_height", 0L), m3.o("org_img_width", 0L)) : null, eVar.q("alg_version", ""));
    }

    public /* synthetic */ ChatContentBot(int i3, String str, String str2, String str3, TransparentInfo transparentInfo, ImageInfo imageInfo, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", "", null, null, "");
    }
}
