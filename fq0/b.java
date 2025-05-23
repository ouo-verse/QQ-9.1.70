package fq0;

import android.view.View;
import com.tencent.android.androidbypass.parser.c;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JB\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001c2\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0006R<\u0010\"\u001a*\u0012\u0004\u0012\u00020 \u0012 \u0012\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\r0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010!\u00a8\u0006%"}, d2 = {"Lfq0/b;", "", "Landroid/view/View;", "view", "", "a", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "message", "", "content", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "btnElem", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "inlineBtnElem", "j", "clickText", "i", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btn", h.F, "", "d", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "g", "", "b", "f", "Ljava/util/WeakHashMap;", "", "Ljava/util/WeakHashMap;", "msgParamsCache", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f400314a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final WeakHashMap<Long, HashMap<String, Object>> msgParamsCache = new WeakHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"fq0/b$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f400316d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InlineKeyboardElement f400317e;

        a(View view, InlineKeyboardElement inlineKeyboardElement) {
            this.f400316d = view;
            this.f400317e = inlineKeyboardElement;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            VideoReport.reportEvent("imp", this.f400316d, null);
            if (this.f400317e != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("eid", "em_qqrobot_inlinekeyboard_message");
                VideoReport.reportEvent("imp", this.f400316d, hashMap);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            this.f400316d.removeOnAttachStateChangeListener(this);
            if (this.f400317e != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("eid", "em_qqrobot_inlinekeyboard_message");
                VideoReport.reportEvent("imp_end", this.f400316d, hashMap);
            }
        }
    }

    b() {
    }

    private final void a(View view) {
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    private final HashMap<String, Object> e(GuildMsgItem message, String content, InlineKeyboardElement btnElem) {
        int i3;
        String str;
        String channelName;
        String guildName;
        JSONObject a16;
        JSONObject a17;
        WeakHashMap<Long, HashMap<String, Object>> weakHashMap = msgParamsCache;
        if (weakHashMap.containsKey(Long.valueOf(message.getMsgId()))) {
            return weakHashMap.get(Long.valueOf(message.getMsgId()));
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        com.tencent.android.androidbypass.parser.b a18 = c.a(content);
        if (a18 != null && (a17 = a18.a()) != null) {
            i3 = a17.optInt("type");
        } else {
            i3 = 0;
        }
        hashMap.put("sgrp_type", Integer.valueOf(i3));
        if (a18 == null || (a16 = a18.a()) == null || (str = Integer.valueOf(a16.optInt("id")).toString()) == null) {
            str = "";
        }
        hashMap.put("sgrp_template_id", str);
        weakHashMap.put(Long.valueOf(message.getMsgId()), hashMap);
        if (btnElem != null) {
            String guildId = message.getMsgRecord().guildId;
            String channelId = message.getMsgRecord().channelId;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return hashMap;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
            IGPSService iGPSService = (IGPSService) runtimeService;
            IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildId);
            IGProChannelInfo channelInfo = iGPSService.getChannelInfo(channelId);
            if (channelInfo == null || (channelName = channelInfo.getChannelName()) == null) {
                channelName = message.getMsgRecord().channelName;
            }
            if (guildInfo == null || (guildName = guildInfo.getGuildName()) == null) {
                guildName = message.getMsgRecord().guildName;
            }
            hashMap.put("qq_robot_role_type", String.valueOf(g(guildInfo)));
            Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
            hashMap.put("qq_robot_channel_id", guildId);
            Intrinsics.checkNotNullExpressionValue(guildName, "guildName");
            hashMap.put("qq_robot_channel_name", guildName);
            Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
            hashMap.put("qq_robot_sub_channel_id", channelId);
            Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
            hashMap.put("qq_robot_sub_channel_name", channelName);
            hashMap.put("qq_robot_message_id", String.valueOf(message.getMsgId()));
            String str2 = message.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str2, "message.msgRecord.senderUid");
            hashMap.put("qq_robot_robot_id", str2);
            hashMap.put("qq_robot_robot_role_type", String.valueOf(f(message)));
        }
        return hashMap;
    }

    @NotNull
    public final Map<String, String> b(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btn) {
        Intrinsics.checkNotNullParameter(btn, "btn");
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_inlinekeyboard_btn_id", btn.c());
        hashMap.put("qq_robot_inlinekeyboard_btn_type", String.valueOf(d(btn)));
        hashMap.put("qq_robot_inlinekeyboard_btn_word_before", btn.f().b());
        hashMap.put("qq_robot_inlinekeyboard_btn_word_after", btn.f().e());
        hashMap.put("qq_robot_inlinekeyboard_btn_style", String.valueOf(c(btn)));
        return hashMap;
    }

    public final int c(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btn) {
        Intrinsics.checkNotNullParameter(btn, "btn");
        int c16 = btn.f().c();
        if (c16 != 0) {
            if (c16 == 1) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public final int d(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btn) {
        Intrinsics.checkNotNullParameter(btn, "btn");
        int c16 = btn.a().c();
        boolean z16 = true;
        if (c16 == 0) {
            return 1;
        }
        if (c16 == 1) {
            return 0;
        }
        if (c16 != 2) {
            if (c16 == 3) {
                return 1;
            }
            return btn.a().c();
        }
        if (btn.a().a().length() != 0) {
            z16 = false;
        }
        if (!z16) {
            return 3;
        }
        return 2;
    }

    public final int f(@NotNull GuildMsgItem message) {
        Intrinsics.checkNotNullParameter(message, "message");
        int i3 = (int) message.getMsgRecord().roleId;
        if (i3 != 2 && i3 != 7 && i3 != 4 && i3 != 5) {
            return 1;
        }
        return 0;
    }

    public final int g(@Nullable IGProGuildInfo guildInfo) {
        if (guildInfo == null) {
            return 2;
        }
        int userType = guildInfo.getUserType();
        if (userType == 1) {
            return 1;
        }
        if (userType != 2) {
            return 2;
        }
        return 0;
    }

    public final void h(@NotNull View view, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btn) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(btn, "btn");
        VideoReport.setElementId(view, "em_qqrobot_inlinekeyboard_btn");
        a(view);
        VideoReport.reportEvent("clck", view, b(btn));
    }

    public final void i(@NotNull View view, @Nullable String clickText) {
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.put("eid", "em_sgrp_markdown");
        if (clickText == null) {
            clickText = "";
        }
        hashMap.put("sgrp_text_content", clickText);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    public final void j(@NotNull View view, @Nullable GuildMsgItem message, @NotNull String content, @Nullable InlineKeyboardElement inlineBtnElem) {
        HashMap<String, Object> e16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(content, "content");
        if (message == null || (e16 = e(message, content, inlineBtnElem)) == null) {
            return;
        }
        if (inlineBtnElem == null && !e16.containsKey("sgrp_template_id") && !e16.containsKey("sgrp_type")) {
            return;
        }
        VideoReport.setElementId(view, "em_sgrp_markdown");
        VideoReport.setElementParams(view, e16);
        a(view);
        view.addOnAttachStateChangeListener(new a(view, inlineBtnElem));
    }
}
