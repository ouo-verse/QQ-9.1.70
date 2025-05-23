package com.tencent.mobileqq.vas.adv.web.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u0000 \u00032\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent;", "", "Callback", "Companion", "Publisher", "Subscriber", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface VasAdvWebEvent {
    public static final int CLICK_AREA_AVATAR = 1;
    public static final int CLICK_AREA_BUTTON = 4;
    public static final int CLICK_AREA_FEEDBACK = 5;
    public static final int CLICK_AREA_NICKNAME = 2;
    public static final int CLICK_AREA_TEXT = 3;
    public static final int CLICK_AREA_VIDEO = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String GET_GDT_AD_DATA = "get_gdt_ad_data";

    @NotNull
    public static final String HANDLE_WEB_CLICK = "handle_web_click";

    @NotNull
    public static final String NOTIFY_WEB_STATUS = "notify_web_status";
    public static final int WEB_STATUS_INIT = 0;
    public static final int WEB_STATUS_LOAD_AD = 1;
    public static final int WEB_STATUS_READY = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "", "onResult", "", "data", "errMsg", "", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface Callback {
        void onResult(@Nullable Object data, @Nullable String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Companion;", "", "()V", "CLICK_AREA_AVATAR", "", "CLICK_AREA_BUTTON", "CLICK_AREA_FEEDBACK", "CLICK_AREA_NICKNAME", "CLICK_AREA_TEXT", "CLICK_AREA_VIDEO", "GET_GDT_AD_DATA", "", "HANDLE_WEB_CLICK", "NOTIFY_WEB_STATUS", "WEB_STATUS_INIT", "WEB_STATUS_LOAD_AD", "WEB_STATUS_READY", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CLICK_AREA_AVATAR = 1;
        public static final int CLICK_AREA_BUTTON = 4;
        public static final int CLICK_AREA_FEEDBACK = 5;
        public static final int CLICK_AREA_NICKNAME = 2;
        public static final int CLICK_AREA_TEXT = 3;
        public static final int CLICK_AREA_VIDEO = 0;

        @NotNull
        public static final String GET_GDT_AD_DATA = "get_gdt_ad_data";

        @NotNull
        public static final String HANDLE_WEB_CLICK = "handle_web_click";

        @NotNull
        public static final String NOTIFY_WEB_STATUS = "notify_web_status";
        public static final int WEB_STATUS_INIT = 0;
        public static final int WEB_STATUS_LOAD_AD = 1;
        public static final int WEB_STATUS_READY = 2;

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Publisher;", "", "subscribe", "", "businessId", "", "subscriber", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "unsubscribe", "unsubscribeAll", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface Publisher {
        void subscribe(@NotNull String businessId, @NotNull Subscriber subscriber);

        void unsubscribe(@NotNull String businessId, @NotNull Subscriber subscriber);

        void unsubscribeAll(@NotNull String businessId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "", "onVasEvent", "", "eventKey", "", "callback", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "data", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface Subscriber {
        void onVasEvent(@NotNull String eventKey, @Nullable Callback callback, @NotNull Object... data);
    }
}
