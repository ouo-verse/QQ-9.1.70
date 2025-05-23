package com.tencent.guild.api.input;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/api/input/GuildAioInputMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetInputEditTextEventR", "InputDeleteEvent", "UpdateSendBtnClickable", "Lcom/tencent/guild/api/input/GuildAioInputMsgIntent$GetInputEditTextEventR;", "Lcom/tencent/guild/api/input/GuildAioInputMsgIntent$InputDeleteEvent;", "Lcom/tencent/guild/api/input/GuildAioInputMsgIntent$UpdateSendBtnClickable;", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildAioInputMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/api/input/GuildAioInputMsgIntent$GetInputEditTextEventR;", "Lcom/tencent/guild/api/input/GuildAioInputMsgIntent;", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetInputEditTextEventR extends GuildAioInputMsgIntent {
        public GetInputEditTextEventR() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/api/input/GuildAioInputMsgIntent$InputDeleteEvent;", "Lcom/tencent/guild/api/input/GuildAioInputMsgIntent;", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class InputDeleteEvent extends GuildAioInputMsgIntent {
        public InputDeleteEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/api/input/GuildAioInputMsgIntent$UpdateSendBtnClickable;", "Lcom/tencent/guild/api/input/GuildAioInputMsgIntent;", "", "d", "Z", "a", "()Z", "clickable", "<init>", "(Z)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateSendBtnClickable extends GuildAioInputMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean clickable;

        public UpdateSendBtnClickable(boolean z16) {
            super(null);
            this.clickable = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getClickable() {
            return this.clickable;
        }
    }

    public /* synthetic */ GuildAioInputMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    GuildAioInputMsgIntent() {
    }
}
