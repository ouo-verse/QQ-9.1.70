package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import p35.ab;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerFeedRepo$fetchFeedList$1 extends Lambda implements Function4<ab, byte[], Integer, String, Unit> {
    public final /* synthetic */ String $anchorId;
    public final /* synthetic */ Function3<ab, Integer, String, Unit> $callback;
    public final /* synthetic */ String $userId;
    public final /* synthetic */ StrangerFeedRepo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StrangerFeedRepo$fetchFeedList$1(StrangerFeedRepo strangerFeedRepo, String str, String str2, Function3<? super ab, ? super Integer, ? super String, Unit> function3) {
        super(4);
        this.this$0 = strangerFeedRepo;
        this.$userId = str;
        this.$anchorId = str2;
        this.$callback = function3;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Unit invoke(ab abVar, byte[] bArr, Integer num, String str) {
        ab abVar2 = abVar;
        int intValue = num.intValue();
        String str2 = str;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchFeedList: rspIsNull=");
        m3.append(abVar2 == null);
        m3.append(" appId=");
        m3.append(this.this$0.appId);
        m3.append(" userId=");
        StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, this.$userId, ", code=", intValue, ", msg=");
        m16.append(str2);
        m16.append(", anchorId: ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, this.$anchorId, kLog, "StrangerFeedRepo");
        this.$callback.invoke(abVar2, Integer.valueOf(intValue), str2);
        return Unit.INSTANCE;
    }
}
