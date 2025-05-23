package com.tencent.qqnt.markdown.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.android.androidbypass.codeblock.config.c;
import com.tencent.android.androidbypass.codeblock.config.highlight.DefaultHighlightConfig;
import com.tencent.android.androidbypass.codeblock.config.highlight.NightHighlightConfig;
import com.tencent.android.androidbypass.codeblock.config.highlight.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi;
import com.tencent.qqnt.markdown.codeblock.CodeBlockFullFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/markdown/api/impl/MarkdownCodeBlockConfigApiImpl;", "Lcom/tencent/qqnt/markdown/api/IMarkdownCodeBlockConfigApi;", "", "checkShowCodeBlockSwitchFromMMKV", "checkShowAllCodeSwitchFromMMKV", "checkEnableBitmapCacheFromMMKV", "checkEnableDrawVisibleRectMMKVForAIO", "isEnableCodeBlockHighlight", "", "getCodeBlockMaxLineCountInAIO", "Landroid/content/Context;", "context", "", IjkMediaMeta.IJKM_KEY_LANGUAGE, "code", "", "openViewAllCodeBlockPage", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "buildCodeBlockConfigForAIO", "<init>", "()V", "Companion", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MarkdownCodeBlockConfigApiImpl implements IMarkdownCodeBlockConfigApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String ENABLE_BITMAP_CACHE_SWITCH = "enable_bitmap_cache_switch";

    @NotNull
    private static final String ENABLE_DRAW_VISIBLE_RECT_SWITCH_FOR_AIO = "enable_draw_visible_rect_switch_for_aio";

    @NotNull
    private static final String ENABLE_HIGHLIGHT_SWITCH_ID = "101359";

    @NotNull
    private static final String LANGUAGE_FLAG = "```";
    private static final int MAX_LINE_COUNT_IN_AIO = 20;

    @NotNull
    private static final String NEW_LINE = "\n";

    @NotNull
    private static final String SHOW_ALL_CODE_SWITCH = "show_all_code_switch";

    @NotNull
    private static final String SHOW_CODE_BLOCK_SWITCH = "show_code_block_switch";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/markdown/api/impl/MarkdownCodeBlockConfigApiImpl$a;", "", "", "ENABLE_BITMAP_CACHE_SWITCH", "Ljava/lang/String;", "ENABLE_DRAW_VISIBLE_RECT_SWITCH_FOR_AIO", "ENABLE_HIGHLIGHT_SWITCH_ID", "LANGUAGE_FLAG", "", "MAX_LINE_COUNT_IN_AIO", "I", "NEW_LINE", "SHOW_ALL_CODE_SWITCH", "SHOW_CODE_BLOCK_SWITCH", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.api.impl.MarkdownCodeBlockConfigApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31390);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MarkdownCodeBlockConfigApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean checkEnableBitmapCacheFromMMKV() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool(ENABLE_BITMAP_CACHE_SWITCH + peekAppRuntime.getCurrentAccountUin(), false);
    }

    private final boolean checkEnableDrawVisibleRectMMKVForAIO() {
        return false;
    }

    private final boolean checkShowAllCodeSwitchFromMMKV() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool(SHOW_ALL_CODE_SWITCH + peekAppRuntime.getCurrentAccountUin(), false);
    }

    private final boolean checkShowCodeBlockSwitchFromMMKV() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool(SHOW_CODE_BLOCK_SWITCH + peekAppRuntime.getCurrentAccountUin(), true);
    }

    @Override // com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi
    @NotNull
    public c buildCodeBlockConfigForAIO(@NotNull final Context context) {
        a nightHighlightConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.android.androidbypass.codeblock.config.background.a aVar = new com.tencent.android.androidbypass.codeblock.config.background.a(context, context.getColor(R.color.qui_common_fill_standard_primary));
        int codeBlockMaxLineCountInAIO = getCodeBlockMaxLineCountInAIO();
        if (!QQTheme.isVasTheme() && !QQTheme.isNowThemeIsNight()) {
            nightHighlightConfig = new DefaultHighlightConfig(context, codeBlockMaxLineCountInAIO);
        } else {
            nightHighlightConfig = new NightHighlightConfig(context, codeBlockMaxLineCountInAIO);
        }
        com.tencent.android.androidbypass.codeblock.config.bottom.a aVar2 = new com.tencent.android.androidbypass.codeblock.config.bottom.a(context, context.getColor(R.color.qui_common_border_standard), context.getColor(R.color.qui_common_text_secondary));
        return new com.tencent.android.androidbypass.codeblock.config.a().e(nightHighlightConfig).a(aVar).b(aVar2).d(new com.tencent.android.androidbypass.codeblock.config.global.a(context, checkEnableDrawVisibleRectMMKVForAIO(), true, new Function2<String, String, Unit>(context) { // from class: com.tencent.qqnt.markdown.api.impl.MarkdownCodeBlockConfigApiImpl$buildCodeBlockConfigForAIO$globalConfig$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MarkdownCodeBlockConfigApiImpl.this, (Object) context);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String originText, @NotNull String language) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) originText, (Object) language);
                    return;
                }
                Intrinsics.checkNotNullParameter(originText, "originText");
                Intrinsics.checkNotNullParameter(language, "language");
                MarkdownCodeBlockConfigApiImpl.this.openViewAllCodeBlockPage(this.$context, language, originText);
            }
        })).c();
    }

    @Override // com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi
    public int getCodeBlockMaxLineCountInAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 20;
    }

    @Override // com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi
    public boolean isEnableCodeBlockHighlight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(ENABLE_HIGHLIGHT_SWITCH_ID, false);
    }

    @Override // com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi
    public void openViewAllCodeBlockPage(@NotNull Context context, @NotNull String language, @NotNull String code) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, language, code);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(code, "code");
        if (context instanceof Activity) {
            CodeBlockFullFragment.INSTANCE.a((Activity) context, LANGUAGE_FLAG + language + '\n' + code + LANGUAGE_FLAG);
        }
    }
}
