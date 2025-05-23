package com.tencent.mobileqq.gamecenter.nt.aio.title;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\t\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "JumpAddFriendEvent", "JumpSettingEvent", "KingIconClick", "KingIconUpdate", "KingOrWeeklyIconRedDotUpdate", "MainTitleClickEvent", "MetaDreamAddFriendEvent", "MetaDreamAddFriendIconClick", "WeeklyIconUpdate", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$JumpAddFriendEvent;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$JumpSettingEvent;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$KingIconClick;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$KingIconUpdate;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$KingOrWeeklyIconRedDotUpdate;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$MainTitleClickEvent;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$MetaDreamAddFriendEvent;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$MetaDreamAddFriendIconClick;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$WeeklyIconUpdate;", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public abstract class GameMsgTitleEvent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$JumpAddFriendEvent;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class JumpAddFriendEvent extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final JumpAddFriendEvent f212235d = new JumpAddFriendEvent();

        JumpAddFriendEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$JumpSettingEvent;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class JumpSettingEvent extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final JumpSettingEvent f212236d = new JumpSettingEvent();

        JumpSettingEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$KingIconClick;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class KingIconClick extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final KingIconClick f212237d = new KingIconClick();

        KingIconClick() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$KingIconUpdate;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "iconUrl", "<init>", "(Ljava/lang/String;)V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class KingIconUpdate extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String iconUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KingIconUpdate(@NotNull String iconUrl) {
            super(null);
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            this.iconUrl = iconUrl;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$KingOrWeeklyIconRedDotUpdate;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class KingOrWeeklyIconRedDotUpdate extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final KingOrWeeklyIconRedDotUpdate f212239d = new KingOrWeeklyIconRedDotUpdate();

        KingOrWeeklyIconRedDotUpdate() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$MainTitleClickEvent;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class MainTitleClickEvent extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MainTitleClickEvent f212240d = new MainTitleClickEvent();

        MainTitleClickEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$MetaDreamAddFriendEvent;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class MetaDreamAddFriendEvent extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MetaDreamAddFriendEvent f212241d = new MetaDreamAddFriendEvent();

        MetaDreamAddFriendEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$MetaDreamAddFriendIconClick;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class MetaDreamAddFriendIconClick extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MetaDreamAddFriendIconClick f212242d = new MetaDreamAddFriendIconClick();

        MetaDreamAddFriendIconClick() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent$WeeklyIconUpdate;", "Lcom/tencent/mobileqq/gamecenter/nt/aio/title/GameMsgTitleEvent;", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "a", "()Lorg/json/JSONObject;", "dataObj", "<init>", "(Lorg/json/JSONObject;)V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class WeeklyIconUpdate extends GameMsgTitleEvent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final JSONObject dataObj;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeeklyIconUpdate(@NotNull JSONObject dataObj) {
            super(null);
            Intrinsics.checkNotNullParameter(dataObj, "dataObj");
            this.dataObj = dataObj;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final JSONObject getDataObj() {
            return this.dataObj;
        }
    }

    public /* synthetic */ GameMsgTitleEvent(DefaultConstructorMarker defaultConstructorMarker) {
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

    GameMsgTitleEvent() {
    }
}
