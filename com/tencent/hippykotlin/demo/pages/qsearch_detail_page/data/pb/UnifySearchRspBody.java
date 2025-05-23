package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchRspBody implements ISSOReqModel, ISSORspModel<UnifySearchRspBody> {
    public final String busiSessionInfo;
    public String correctionQuery;
    public final String errorMsg;
    public final String extension;
    public final int isEnd;
    public final int resultCode;
    public final String sessionInfo;
    public final UnifySearchTabContentResult tabContentResult;

    public UnifySearchRspBody() {
        this(0, null, null, 0, null, null, null, null, 255, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchRspBody decode(e eVar) {
        int k3 = eVar.k("result_code", 0);
        String q16 = eVar.q("error_msg", "");
        e m3 = eVar.m("tab_content_result");
        return new UnifySearchRspBody(k3, q16, m3 != null ? new UnifySearchTabContentResult(null, null, null).decode(m3) : null, eVar.k("is_end", 0), eVar.q(AppConstants.Key.SESSION_INFO, ""), eVar.q("busi_session_info", ""), eVar.q("correction_query", ""), eVar.q(MimeTypeParser.ATTR_EXTENSION, ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("result_code", this.resultCode);
        eVar.v("error_msg", this.errorMsg);
        UnifySearchTabContentResult unifySearchTabContentResult = this.tabContentResult;
        if (unifySearchTabContentResult != null) {
            eVar.v("tab_content_result", unifySearchTabContentResult.encode());
        }
        eVar.t("is_end", this.isEnd);
        eVar.v(AppConstants.Key.SESSION_INFO, this.sessionInfo);
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        return eVar;
    }

    public UnifySearchRspBody(int i3, String str, UnifySearchTabContentResult unifySearchTabContentResult, int i16, String str2, String str3, String str4, String str5) {
        this.resultCode = i3;
        this.errorMsg = str;
        this.tabContentResult = unifySearchTabContentResult;
        this.isEnd = i16;
        this.sessionInfo = str2;
        this.busiSessionInfo = str3;
        this.correctionQuery = str4;
        this.extension = str5;
    }

    public /* synthetic */ UnifySearchRspBody(int i3, String str, UnifySearchTabContentResult unifySearchTabContentResult, int i16, String str2, String str3, String str4, String str5, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null, 0, "", "", "", "");
    }
}
