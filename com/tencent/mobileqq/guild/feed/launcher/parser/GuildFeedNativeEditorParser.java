package com.tencent.mobileqq.guild.feed.launcher.parser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchOptionModel;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchSourceModel;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedSchemeBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/launcher/parser/GuildFeedNativeEditorParser;", "Lcom/tencent/mobileqq/guild/feed/launcher/parser/a;", "Landroid/content/Context;", "context", "", "guildId", "com/tencent/mobileqq/guild/feed/launcher/parser/GuildFeedNativeEditorParser$makeCheckItemListener$1", "d", "(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/guild/feed/launcher/parser/GuildFeedNativeEditorParser$makeCheckItemListener$1;", "Lcom/tencent/mobileqq/guild/feed/launcher/parser/GuildFeedNativeEditorParser$ShowLoadingRunnable;", "c", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedSchemeBean;", "bean", "", "b", "<init>", "()V", "a", "ShowLoadingRunnable", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedNativeEditorParser extends com.tencent.mobileqq.guild.feed.launcher.parser.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f220079a = new a(null);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/launcher/parser/GuildFeedNativeEditorParser$ShowLoadingRunnable;", "Ljava/lang/Runnable;", "", "f", "e", TencentLocation.RUN_MODE, "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/DialogInterface;", "Landroid/content/DialogInterface;", "dialogInterface", "", "Z", "isSubmit", "<init>", "(Landroid/app/Activity;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ShowLoadingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Activity activity;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private DialogInterface dialogInterface;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isSubmit;

        public ShowLoadingRunnable(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activity = activity;
        }

        public final void e() {
            DialogInterface dialogInterface;
            if (!this.isSubmit) {
                return;
            }
            this.isSubmit = false;
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this);
            if (!this.activity.isFinishing() && (dialogInterface = this.dialogInterface) != null) {
                dialogInterface.dismiss();
            }
            this.dialogInterface = null;
        }

        public final void f() {
            this.isSubmit = true;
            ThreadManagerV2.getUIHandlerV2().postDelayed(this, 100L);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.activity.isFinishing()) {
                Dialog dialog = null;
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this.activity, null, false);
                if (showLoadingDialog != null) {
                    showLoadingDialog.show();
                    dialog = showLoadingDialog;
                }
                this.dialogInterface = dialog;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/launcher/parser/GuildFeedNativeEditorParser$a;", "", "", "SCHEME_KEY_DEBUG_PAGE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final ShowLoadingRunnable c() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return null;
        }
        if (qBaseActivity.isAttachedToWindow()) {
            ShowLoadingRunnable showLoadingRunnable = new ShowLoadingRunnable(qBaseActivity);
            showLoadingRunnable.f();
            return showLoadingRunnable;
        }
        QLog.e("GuildFeedNativeEditorParser", 1, "topActivity=" + qBaseActivity + " not attached to window");
        return null;
    }

    private final GuildFeedNativeEditorParser$makeCheckItemListener$1 d(Context context, String guildId) {
        return new GuildFeedNativeEditorParser$makeCheckItemListener$1(context, guildId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b8, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r7);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.guild.feed.launcher.parser.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@Nullable Context context, @Nullable GuildFeedSchemeBean bean) {
        boolean z16;
        String str;
        String str2;
        boolean z17;
        Serializable serializable;
        int i3;
        Serializable serializable2;
        int i16;
        Serializable serializable3;
        Long l3;
        Serializable serializable4;
        String str3;
        Object obj;
        String str4;
        Object obj2;
        String str5;
        Object obj3;
        String str6;
        Object obj4;
        String str7;
        JSONObject jSONObject;
        Integer intOrNull;
        Integer intOrNull2;
        if (bean != null && context != null) {
            HashMap<String, Serializable> attrs = bean.getAttrs();
            int i17 = 0;
            if (attrs != null && !attrs.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QLog.i("GuildFeedNativeEditorParser", 1, "bean.attr=" + bean.getAttrs());
                Map attrs2 = bean.getAttrs();
                if (attrs2 == null) {
                    attrs2 = MapsKt__MapsKt.emptyMap();
                }
                Object obj5 = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218117c);
                JSONObject jSONObject2 = null;
                if (obj5 instanceof String) {
                    str = (String) obj5;
                } else {
                    str = null;
                }
                String str8 = "";
                if (str == null) {
                    str = "";
                }
                Object obj6 = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218119e);
                if (obj6 instanceof String) {
                    str2 = (String) obj6;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                }
                GuildSimpleContact guildSimpleContact = new GuildSimpleContact(str, str2);
                Serializable serializable5 = (Serializable) attrs2.get(com.tencent.mobileqq.guild.feed.b.f218135u);
                if (serializable5 != null) {
                    if (!(serializable5 instanceof String)) {
                        serializable5 = null;
                    }
                    String str9 = (String) serializable5;
                    if (str9 != null) {
                        z17 = yl1.i.f450608a.k(MiscKt.k(str9));
                        serializable = (Serializable) attrs2.get(com.tencent.mobileqq.guild.feed.b.f218139y);
                        if (serializable != null) {
                            if (!(serializable instanceof String)) {
                                serializable = null;
                            }
                            String str10 = (String) serializable;
                            if (str10 != null) {
                                i3 = MiscKt.k(str10);
                                serializable2 = (Serializable) attrs2.get(com.tencent.mobileqq.guild.feed.b.f218138x);
                                if (serializable2 != null) {
                                    if (!(serializable2 instanceof String)) {
                                        serializable2 = null;
                                    }
                                    String str11 = (String) serializable2;
                                    if (str11 != null && intOrNull2 != null) {
                                        i16 = intOrNull2.intValue();
                                        FeedEditorLaunchOptionModel feedEditorLaunchOptionModel = new FeedEditorLaunchOptionModel(z17, i3, i16);
                                        feedEditorLaunchOptionModel.setPanicModeInMediaFilterStep(false);
                                        serializable3 = (Serializable) attrs2.get("topic_id");
                                        if (serializable3 != null) {
                                            if (!(serializable3 instanceof String)) {
                                                serializable3 = null;
                                            }
                                            String str12 = (String) serializable3;
                                            if (str12 != null) {
                                                l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str12);
                                                feedEditorLaunchOptionModel.setTopicId(l3);
                                                serializable4 = (Serializable) attrs2.get("topic_name");
                                                if (serializable4 != null) {
                                                    if (!(serializable4 instanceof String)) {
                                                        serializable4 = null;
                                                    }
                                                    str3 = (String) serializable4;
                                                } else {
                                                    str3 = null;
                                                }
                                                feedEditorLaunchOptionModel.setTopicName(str3);
                                                obj = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218136v);
                                                if (!(obj instanceof String)) {
                                                    obj = null;
                                                }
                                                str4 = (String) obj;
                                                if (str4 != null && intOrNull != null) {
                                                    i17 = intOrNull.intValue();
                                                }
                                                obj2 = attrs2.get("sgrp_stream_pgin_source_name");
                                                if (!(obj2 instanceof String)) {
                                                    obj2 = null;
                                                }
                                                str5 = (String) obj2;
                                                if (str5 == null) {
                                                    str5 = "";
                                                }
                                                obj3 = attrs2.get("sgrp_visit_from");
                                                if (!(obj3 instanceof String)) {
                                                    obj3 = null;
                                                }
                                                str6 = (String) obj3;
                                                if (str6 != null) {
                                                    str8 = str6;
                                                }
                                                FeedEditorLaunchSourceModel feedEditorLaunchSourceModel = new FeedEditorLaunchSourceModel(i17, str8, str5);
                                                obj4 = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218137w);
                                                if (!(obj4 instanceof String)) {
                                                    obj4 = null;
                                                }
                                                str7 = (String) obj4;
                                                if (str7 != null) {
                                                    try {
                                                        Result.Companion companion = Result.INSTANCE;
                                                        jSONObject = Result.m476constructorimpl(new JSONObject(str7));
                                                    } catch (Throwable th5) {
                                                        Result.Companion companion2 = Result.INSTANCE;
                                                        jSONObject = Result.m476constructorimpl(ResultKt.createFailure(th5));
                                                    }
                                                    if (!Result.m482isFailureimpl(jSONObject)) {
                                                        jSONObject2 = jSONObject;
                                                    }
                                                    jSONObject2 = jSONObject2;
                                                }
                                                ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).performCheckItemsToStartFeedEditorToPostNewOne(context, guildSimpleContact, feedEditorLaunchOptionModel, feedEditorLaunchSourceModel, jSONObject2, d(context, guildSimpleContact.getGuildId()), null).invokeOnCompletion(new GuildFeedNativeEditorParser$parse$1(c()));
                                            }
                                        }
                                        l3 = null;
                                        feedEditorLaunchOptionModel.setTopicId(l3);
                                        serializable4 = (Serializable) attrs2.get("topic_name");
                                        if (serializable4 != null) {
                                        }
                                        feedEditorLaunchOptionModel.setTopicName(str3);
                                        obj = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218136v);
                                        if (!(obj instanceof String)) {
                                        }
                                        str4 = (String) obj;
                                        if (str4 != null) {
                                            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str4);
                                            i17 = intOrNull.intValue();
                                        }
                                        obj2 = attrs2.get("sgrp_stream_pgin_source_name");
                                        if (!(obj2 instanceof String)) {
                                        }
                                        str5 = (String) obj2;
                                        if (str5 == null) {
                                        }
                                        obj3 = attrs2.get("sgrp_visit_from");
                                        if (!(obj3 instanceof String)) {
                                        }
                                        str6 = (String) obj3;
                                        if (str6 != null) {
                                        }
                                        FeedEditorLaunchSourceModel feedEditorLaunchSourceModel2 = new FeedEditorLaunchSourceModel(i17, str8, str5);
                                        obj4 = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218137w);
                                        if (!(obj4 instanceof String)) {
                                        }
                                        str7 = (String) obj4;
                                        if (str7 != null) {
                                        }
                                        ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).performCheckItemsToStartFeedEditorToPostNewOne(context, guildSimpleContact, feedEditorLaunchOptionModel, feedEditorLaunchSourceModel2, jSONObject2, d(context, guildSimpleContact.getGuildId()), null).invokeOnCompletion(new GuildFeedNativeEditorParser$parse$1(c()));
                                    }
                                }
                                i16 = 0;
                                FeedEditorLaunchOptionModel feedEditorLaunchOptionModel2 = new FeedEditorLaunchOptionModel(z17, i3, i16);
                                feedEditorLaunchOptionModel2.setPanicModeInMediaFilterStep(false);
                                serializable3 = (Serializable) attrs2.get("topic_id");
                                if (serializable3 != null) {
                                }
                                l3 = null;
                                feedEditorLaunchOptionModel2.setTopicId(l3);
                                serializable4 = (Serializable) attrs2.get("topic_name");
                                if (serializable4 != null) {
                                }
                                feedEditorLaunchOptionModel2.setTopicName(str3);
                                obj = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218136v);
                                if (!(obj instanceof String)) {
                                }
                                str4 = (String) obj;
                                if (str4 != null) {
                                }
                                obj2 = attrs2.get("sgrp_stream_pgin_source_name");
                                if (!(obj2 instanceof String)) {
                                }
                                str5 = (String) obj2;
                                if (str5 == null) {
                                }
                                obj3 = attrs2.get("sgrp_visit_from");
                                if (!(obj3 instanceof String)) {
                                }
                                str6 = (String) obj3;
                                if (str6 != null) {
                                }
                                FeedEditorLaunchSourceModel feedEditorLaunchSourceModel22 = new FeedEditorLaunchSourceModel(i17, str8, str5);
                                obj4 = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218137w);
                                if (!(obj4 instanceof String)) {
                                }
                                str7 = (String) obj4;
                                if (str7 != null) {
                                }
                                ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).performCheckItemsToStartFeedEditorToPostNewOne(context, guildSimpleContact, feedEditorLaunchOptionModel2, feedEditorLaunchSourceModel22, jSONObject2, d(context, guildSimpleContact.getGuildId()), null).invokeOnCompletion(new GuildFeedNativeEditorParser$parse$1(c()));
                            }
                        }
                        i3 = 0;
                        serializable2 = (Serializable) attrs2.get(com.tencent.mobileqq.guild.feed.b.f218138x);
                        if (serializable2 != null) {
                        }
                        i16 = 0;
                        FeedEditorLaunchOptionModel feedEditorLaunchOptionModel22 = new FeedEditorLaunchOptionModel(z17, i3, i16);
                        feedEditorLaunchOptionModel22.setPanicModeInMediaFilterStep(false);
                        serializable3 = (Serializable) attrs2.get("topic_id");
                        if (serializable3 != null) {
                        }
                        l3 = null;
                        feedEditorLaunchOptionModel22.setTopicId(l3);
                        serializable4 = (Serializable) attrs2.get("topic_name");
                        if (serializable4 != null) {
                        }
                        feedEditorLaunchOptionModel22.setTopicName(str3);
                        obj = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218136v);
                        if (!(obj instanceof String)) {
                        }
                        str4 = (String) obj;
                        if (str4 != null) {
                        }
                        obj2 = attrs2.get("sgrp_stream_pgin_source_name");
                        if (!(obj2 instanceof String)) {
                        }
                        str5 = (String) obj2;
                        if (str5 == null) {
                        }
                        obj3 = attrs2.get("sgrp_visit_from");
                        if (!(obj3 instanceof String)) {
                        }
                        str6 = (String) obj3;
                        if (str6 != null) {
                        }
                        FeedEditorLaunchSourceModel feedEditorLaunchSourceModel222 = new FeedEditorLaunchSourceModel(i17, str8, str5);
                        obj4 = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218137w);
                        if (!(obj4 instanceof String)) {
                        }
                        str7 = (String) obj4;
                        if (str7 != null) {
                        }
                        ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).performCheckItemsToStartFeedEditorToPostNewOne(context, guildSimpleContact, feedEditorLaunchOptionModel22, feedEditorLaunchSourceModel222, jSONObject2, d(context, guildSimpleContact.getGuildId()), null).invokeOnCompletion(new GuildFeedNativeEditorParser$parse$1(c()));
                    }
                }
                z17 = false;
                serializable = (Serializable) attrs2.get(com.tencent.mobileqq.guild.feed.b.f218139y);
                if (serializable != null) {
                }
                i3 = 0;
                serializable2 = (Serializable) attrs2.get(com.tencent.mobileqq.guild.feed.b.f218138x);
                if (serializable2 != null) {
                }
                i16 = 0;
                FeedEditorLaunchOptionModel feedEditorLaunchOptionModel222 = new FeedEditorLaunchOptionModel(z17, i3, i16);
                feedEditorLaunchOptionModel222.setPanicModeInMediaFilterStep(false);
                serializable3 = (Serializable) attrs2.get("topic_id");
                if (serializable3 != null) {
                }
                l3 = null;
                feedEditorLaunchOptionModel222.setTopicId(l3);
                serializable4 = (Serializable) attrs2.get("topic_name");
                if (serializable4 != null) {
                }
                feedEditorLaunchOptionModel222.setTopicName(str3);
                obj = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218136v);
                if (!(obj instanceof String)) {
                }
                str4 = (String) obj;
                if (str4 != null) {
                }
                obj2 = attrs2.get("sgrp_stream_pgin_source_name");
                if (!(obj2 instanceof String)) {
                }
                str5 = (String) obj2;
                if (str5 == null) {
                }
                obj3 = attrs2.get("sgrp_visit_from");
                if (!(obj3 instanceof String)) {
                }
                str6 = (String) obj3;
                if (str6 != null) {
                }
                FeedEditorLaunchSourceModel feedEditorLaunchSourceModel2222 = new FeedEditorLaunchSourceModel(i17, str8, str5);
                obj4 = attrs2.get(com.tencent.mobileqq.guild.feed.b.f218137w);
                if (!(obj4 instanceof String)) {
                }
                str7 = (String) obj4;
                if (str7 != null) {
                }
                ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).performCheckItemsToStartFeedEditorToPostNewOne(context, guildSimpleContact, feedEditorLaunchOptionModel222, feedEditorLaunchSourceModel2222, jSONObject2, d(context, guildSimpleContact.getGuildId()), null).invokeOnCompletion(new GuildFeedNativeEditorParser$parse$1(c()));
            }
        }
    }
}
