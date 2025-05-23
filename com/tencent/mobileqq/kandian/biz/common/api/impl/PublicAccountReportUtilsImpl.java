package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016Jh\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016Jp\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J|\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u0084\u0001\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0019\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u000eH\u0016JD\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\"\u001a\u00020\u00072\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/PublicAccountReportUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils;", "()V", "changeToUTF8", "", "str", "publicAccountReportClickEvent", "", "app", "Lcom/tencent/common/app/AppInterface;", "toUin", "subAction", "actionName", IProfileCardConst.KEY_FROM_TYPE, "", "result", "r2", "r3", "r4", "r5", "shouldEncode", "", "publicAccountReportClickEventForMigrate", "tag", "mainAction", "reportFollowEvent", IPublicAccountBrowser.KEY_PUB_UIN, "source", "reportPAinfoToLighthouse", "t", "d1", "d2", "d3", "d4", "reportPubAccMsg", "list", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PublicAccountReportUtilsImpl implements IPublicAccountReportUtils {
    @Override // com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    public String changeToUTF8(String str) {
        String h16 = PublicAccountReportUtils.h(str);
        Intrinsics.checkNotNullExpressionValue(h16, "changeToUTF8(str)");
        return h16;
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    public void publicAccountReportClickEvent(AppInterface app, String toUin, String subAction, String actionName, int fromType, int result, String r26, String r36, String r46, String r56, boolean shouldEncode) {
        PublicAccountReportUtils.l(app, toUin, subAction, actionName, fromType, result, r26, r36, r46, r56, shouldEncode);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    public void publicAccountReportClickEventForMigrate(AppInterface app, String tag, String mainAction, String toUin, String subAction, String actionName, int fromType, int result, String r26, String r36, String r46, String r56) {
        PublicAccountReportUtils.m(app, tag, mainAction, toUin, subAction, actionName, fromType, result, r26, r36, r46, r56);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    public void reportFollowEvent(AppInterface app, String puin, int source) {
        PublicAccountReportUtils.o(app, puin, source);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    public void reportPAinfoToLighthouse(String t16, String puin, String d16, String d26, String d36, String d46) {
        PublicAccountReportUtils.p(t16, puin, d16, d26, d36, d46);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    public void reportPubAccMsg(List<MessageRecord> list) {
        PublicAccountReportUtils.q(list);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    public void publicAccountReportClickEvent(AppInterface app, String toUin, String subAction, String actionName, int fromType, int result, String r26, String r36, String r46, String r56) {
        PublicAccountReportUtils.k(app, toUin, subAction, actionName, fromType, result, r26, r36, r46, r56);
    }

    @Override // com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    public void publicAccountReportClickEventForMigrate(AppInterface app, String tag, String mainAction, String toUin, String subAction, String actionName, int fromType, int result, String r26, String r36, String r46, String r56, boolean shouldEncode) {
        PublicAccountReportUtils.n(app, tag, mainAction, toUin, subAction, actionName, fromType, result, r26, r36, r46, r56, shouldEncode);
    }
}
