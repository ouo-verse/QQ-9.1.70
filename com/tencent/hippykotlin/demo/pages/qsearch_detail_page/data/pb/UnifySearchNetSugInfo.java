package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchNetSugInfo implements ISSOReqModel, ISSORspModel<UnifySearchNetSugInfo> {
    public final String extension;
    public final String hitKeyWord;
    public final String sugWord;

    public UnifySearchNetSugInfo() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("sug_word", this.sugWord);
        eVar.v("hit_key_word", this.hitKeyWord);
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        return eVar;
    }

    public UnifySearchNetSugInfo(String str, String str2, String str3) {
        this.sugWord = str;
        this.hitKeyWord = str2;
        this.extension = str3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchNetSugInfo decode(e eVar) {
        return new UnifySearchNetSugInfo(eVar.q("sug_word", ""), eVar.q("hit_key_word", ""), eVar.q(MimeTypeParser.ATTR_EXTENSION, ""));
    }

    public /* synthetic */ UnifySearchNetSugInfo(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "");
    }
}
