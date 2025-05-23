package com.tencent.mobileqq.gamecenter.nt.aio.title;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTipsEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "HideTips", "ShowTips", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTipsEvent$HideTips;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTipsEvent$ShowTips;", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public abstract class GameMsgTipsEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTipsEvent$HideTips;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTipsEvent;", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class HideTips extends GameMsgTipsEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HideTips f212233d = new HideTips();

        HideTips() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTipsEvent$ShowTips;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTipsEvent;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "tips", "<init>", "(Ljava/lang/String;)V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class ShowTips extends GameMsgTipsEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tips;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowTips(@NotNull String tips) {
            super(null);
            Intrinsics.checkNotNullParameter(tips, "tips");
            this.tips = tips;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getTips() {
            return this.tips;
        }
    }

    public /* synthetic */ GameMsgTipsEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    GameMsgTipsEvent() {
    }
}
