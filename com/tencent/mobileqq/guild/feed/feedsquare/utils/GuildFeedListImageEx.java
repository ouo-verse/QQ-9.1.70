package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0017\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016J#\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R+\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildFeedListImageEx;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "url", "f", "", "kotlin.jvm.PlatformType", "d", "()Ljava/lang/Boolean;", "account", "", "onAccountChanged", "url1", "url2", "g", "(Ljava/lang/String;Ljava/lang/String;)Z", "Ljava/lang/Boolean;", "ignorePicLevel", "Lkotlin/Function1;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "e", "()Lkotlin/jvm/functions/Function1;", "imageUniKeyFunc", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedListImageEx implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildFeedListImageEx f219278d;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f219279e = {Reflection.property1(new PropertyReference1Impl(GuildFeedListImageEx.class, "imageUniKeyFunc", "getImageUniKeyFunc()Lkotlin/jvm/functions/Function1;", 0))};

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Boolean ignorePicLevel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a imageUniKeyFunc;

    static {
        final GuildFeedListImageEx guildFeedListImageEx = new GuildFeedListImageEx();
        f219278d = guildFeedListImageEx;
        ignorePicLevel = guildFeedListImageEx.d();
        AccountChangedNotifier.f214789d.a(guildFeedListImageEx);
        imageUniKeyFunc = new a(new MutablePropertyReference0Impl(guildFeedListImageEx) { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageEx$imageUniKeyFunc$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                Boolean bool;
                bool = GuildFeedListImageEx.ignorePicLevel;
                return bool;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                GuildFeedListImageEx.ignorePicLevel = (Boolean) obj;
            }
        }, ComputedKt.a(), new Function1<Boolean, KFunction<? extends String>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageEx$imageUniKeyFunc$3

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageEx$imageUniKeyFunc$3$1, reason: invalid class name */
            /* loaded from: classes13.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, String> {
                AnonymousClass1(Object obj) {
                    super(1, obj, GuildFeedListImageEx.class, "imageUniKey", "imageUniKey(Ljava/lang/String;)Ljava/lang/String;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final String invoke(@Nullable String str) {
                    String f16;
                    f16 = ((GuildFeedListImageEx) this.receiver).f(str);
                    return f16;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageEx$imageUniKeyFunc$3$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, String> {
                public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                AnonymousClass2() {
                    super(1, com.tencent.mobileqq.guild.picload.e.class, "getUniKeyFromUrl", "getUniKeyFromUrl(Ljava/lang/String;)Ljava/lang/String;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(String str) {
                    return com.tencent.mobileqq.guild.picload.e.d(str);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final KFunction<String> invoke(Boolean ignorePicLevel2) {
                Intrinsics.checkNotNullExpressionValue(ignorePicLevel2, "ignorePicLevel");
                return ignorePicLevel2.booleanValue() ? new AnonymousClass1(GuildFeedListImageEx.f219278d) : AnonymousClass2.INSTANCE;
            }
        });
    }

    GuildFeedListImageEx() {
    }

    private final Boolean d() {
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("106047", Boolean.TRUE);
        QLog.i("GuildFeedListImageEx", 1, "obtain ignorePicLevel: " + isSwitchOn);
        return isSwitchOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(String url) {
        boolean z16;
        boolean startsWith$default;
        String substringBefore$default;
        String substringAfter$default;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        if (!RFWFileUtils.isLocalPath(url)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
            if (startsWith$default) {
                substringBefore$default = StringsKt__StringsKt.substringBefore$default(url, "!/", (String) null, 2, (Object) null);
                substringAfter$default = StringsKt__StringsKt.substringAfter$default(substringBefore$default, QzoneWebViewOfflinePlugin.STR_DEVIDER, (String) null, 2, (Object) null);
                return substringAfter$default;
            }
            return url;
        }
        return url;
    }

    @NotNull
    public final Function1<String, String> e() {
        return (Function1) imageUniKeyFunc.getValue(this, f219279e[0]);
    }

    public final boolean g(@Nullable String url1, @Nullable String url2) {
        return Intrinsics.areEqual(e().invoke(url1), e().invoke(url2));
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        ignorePicLevel = d();
    }
}
