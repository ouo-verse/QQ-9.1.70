package a63;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.menu.MenuItem;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u0006\u001a\u00020\u00032(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J2\u0010\u0007\u001a\u00020\u00032(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J:\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003\u00a8\u0006\u0013"}, d2 = {"La63/a;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "g", "d", "Landroid/content/Context;", "context", "name", "La63/b;", "c", "f", "bubbleName", "e", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static a f25602b;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b#\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010!\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0014\u0010#\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0015R\u0014\u0010$\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0015R\u0014\u0010%\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0015R\u0014\u0010&\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0015R\u0014\u0010'\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0015R\u0014\u0010(\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0015R\u0014\u0010)\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0015R\u0014\u0010*\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0015R\u0014\u0010+\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0015R\u0014\u0010,\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0015R\u0014\u0010-\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0015R\u0014\u0010.\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0015\u00a8\u00061"}, d2 = {"La63/a$a;", "", "La63/a;", "a", "La63/b;", "bubbleInfo", "", "e", "", "bubbleName", "f", "Lcom/tencent/mobileqq/wink/editor/menu/MenuItem;", "b", "c", "", "g", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "La63/a;", "d", "()La63/a;", "DEFAULT_BUBBLE_NAME", "Ljava/lang/String;", "PUBLISH_COVER_STICKER", "PUBLISH_TEMPLATE_COVER_STICKER", "TAG", "WINK_AI_ELIMINATION", "WINK_AI_TEMPLATE", "WINK_BACKGROUND", "WINK_CLIP", "WINK_COVER_IMAGE_TIP", "WINK_CROP", "WINK_EFFECT", "WINK_EFFECT_FACE", "WINK_EMOTION_STICKER", "WINK_ENHANCE", "WINK_ENHANCE_TIP", "WINK_FILTER", "WINK_LYRIC_STICKER", "WINK_MOSAIC", "WINK_QZONE_PHOTO_TEMPLATE", "WINK_SMART_CLIP", "WINK_STICKER", "WINK_SUBTITLE", "WINK_TEMPLATE_CLIP", "WINK_TEMPLATE_TEXT_LIST", "WINK_TEXT", "WINK_TRACE_STICKER", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: a63.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final a d() {
            if (a.f25602b == null) {
                a.f25602b = new a();
            }
            return a.f25602b;
        }

        @NotNull
        public final synchronized a a() {
            a d16;
            d16 = d();
            Intrinsics.checkNotNull(d16);
            return d16;
        }

        @Nullable
        public final MenuItem b(@Nullable WinkBubbleInfo bubbleInfo) {
            String str;
            if (bubbleInfo != null) {
                str = bubbleInfo.getName();
            } else {
                str = null;
            }
            return c(str);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0007. Please report as an issue. */
        @Nullable
        public final MenuItem c(@Nullable String bubbleName) {
            MenuItem menuItem;
            if (bubbleName == null) {
                return null;
            }
            switch (bubbleName.hashCode()) {
                case -2094245219:
                    if (!bubbleName.equals("winkBackground")) {
                        return null;
                    }
                    menuItem = MenuItem.BACKGROUND;
                    return menuItem;
                case -1732456832:
                    if (!bubbleName.equals("winkEffect")) {
                        return null;
                    }
                    menuItem = MenuItem.EFFECT;
                    return menuItem;
                case -1524830220:
                    if (!bubbleName.equals("winSubTitle")) {
                        return null;
                    }
                    menuItem = MenuItem.SUBTITLE;
                    return menuItem;
                case -1110235137:
                    if (!bubbleName.equals("winkClip")) {
                        return null;
                    }
                    menuItem = MenuItem.CLIPPING;
                    return menuItem;
                case -1045585057:
                    if (!bubbleName.equals("WinkCrop")) {
                        return null;
                    }
                    menuItem = MenuItem.CROP;
                    return menuItem;
                case -1045090820:
                    if (!bubbleName.equals("WinkText")) {
                        return null;
                    }
                    menuItem = MenuItem.TEXT;
                    return menuItem;
                case -757065676:
                    if (!bubbleName.equals("winkTemplateTextList")) {
                        return null;
                    }
                    menuItem = MenuItem.TEMPLATE_TEXT;
                    return menuItem;
                case -555009522:
                    if (!bubbleName.equals("WinkSticker")) {
                        return null;
                    }
                    menuItem = MenuItem.STICKER;
                    return menuItem;
                case -312140962:
                    if (!bubbleName.equals("winEmotionSticker")) {
                        return null;
                    }
                    menuItem = MenuItem.STICKER;
                    return menuItem;
                case -267914369:
                    if (!bubbleName.equals("WinkEnhance")) {
                        return null;
                    }
                    menuItem = MenuItem.ENHANCE;
                    return menuItem;
                case 292600967:
                    if (!bubbleName.equals("WinkFilter")) {
                        return null;
                    }
                    menuItem = MenuItem.FILTER;
                    return menuItem;
                case 481168871:
                    if (!bubbleName.equals("winkTraceSticker")) {
                        return null;
                    }
                    menuItem = MenuItem.STICKER;
                    return menuItem;
                case 498736537:
                    if (!bubbleName.equals("WinkMosaic")) {
                        return null;
                    }
                    menuItem = MenuItem.MOSAIC;
                    return menuItem;
                case 591889969:
                    if (!bubbleName.equals("WinkAITemplate")) {
                        return null;
                    }
                    menuItem = MenuItem.AI_TEMPLATE;
                    return menuItem;
                case 953342205:
                    if (!bubbleName.equals("winkEffectFace")) {
                        return null;
                    }
                    menuItem = MenuItem.EFFECT;
                    return menuItem;
                case 1024700778:
                    if (!bubbleName.equals("winkSmartClip")) {
                        return null;
                    }
                    menuItem = MenuItem.CLIPPING;
                    return menuItem;
                case 1125807774:
                    if (!bubbleName.equals("winkQzonePhotoTemplate")) {
                        return null;
                    }
                    menuItem = MenuItem.VIDEO_TEMPLATE;
                    return menuItem;
                case 1131707545:
                    if (!bubbleName.equals("winkTemplateClip")) {
                        return null;
                    }
                    menuItem = MenuItem.TEMPLATE_CLIP;
                    return menuItem;
                case 1656247662:
                    if (!bubbleName.equals("WinkAIElimination")) {
                        return null;
                    }
                    menuItem = MenuItem.AI_ELIMINATION;
                    return menuItem;
                default:
                    return null;
            }
        }

        public final boolean e(@NotNull WinkBubbleInfo bubbleInfo) {
            Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
            boolean f16 = f(bubbleInfo.getName());
            ms.a.f("TAG", "isBubbleInfoShowed " + bubbleInfo.getName() + " " + f16);
            return f16;
        }

        public final boolean f(@NotNull String bubbleName) {
            Intrinsics.checkNotNullParameter(bubbleName, "bubbleName");
            return AECameraPrefsUtil.c().b(bubbleName, false, 0);
        }

        public final void g(@NotNull WinkBubbleInfo bubbleInfo) {
            Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
            if (bubbleInfo.getShowLevel() != 3 && bubbleInfo.getShowLevel() != 0) {
                AECameraPrefsUtil.c().h(bubbleInfo.getName(), true, 0);
            }
        }

        Companion() {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final WinkBubbleInfo c(Context context, String name) {
        switch (name.hashCode()) {
            case -2094245219:
                if (name.equals("winkBackground")) {
                    String string = context.getString(R.string.f239177lr);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_background_guide_bubble)");
                    return new WinkBubbleInfo("winkBackground", string, 0, 0L, null, null, 60, null);
                }
                return null;
            case -1732456832:
                if (name.equals("winkEffect")) {
                    String string2 = context.getString(R.string.f215345vc);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026wink_cut_effect_guidance)");
                    return new WinkBubbleInfo("winkEffect", string2, 0, 0L, null, null, 60, null);
                }
                return null;
            case -1550729656:
                if (name.equals("winkCoverImageTip")) {
                    String string3 = context.getString(R.string.f239197lt);
                    Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.wink_editor_cover_try)");
                    return new WinkBubbleInfo("winkCoverImageTip", string3, 2, 0L, null, null, 56, null);
                }
                return null;
            case -1524830220:
                if (name.equals("winSubTitle")) {
                    String string4 = context.getString(R.string.f215465vo);
                    Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026nk_cut_subtitle_guidance)");
                    return new WinkBubbleInfo("winSubTitle", string4, 0, 0L, null, null, 60, null);
                }
                return null;
            case -1110235137:
                if (name.equals("winkClip")) {
                    String string5 = context.getString(R.string.f239317m5, Long.valueOf(WinkConfig.f317649a.a() / 60000));
                    Intrinsics.checkNotNullExpressionValue(string5, "context.getString(\n     \u2026 1_000)\n                )");
                    return new WinkBubbleInfo("winkClip", string5, 3, 0L, null, null, 56, null);
                }
                return null;
            case -1045090820:
                if (name.equals("WinkText")) {
                    String string6 = context.getString(R.string.f215595w1);
                    Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri\u2026qqwink_editable_text_new)");
                    return new WinkBubbleInfo("WinkText", string6, 2, 0L, null, null, 56, null);
                }
                return null;
            case -757065676:
                if (name.equals("winkTemplateTextList")) {
                    String string7 = context.getString(R.string.f215585w0);
                    Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.stri\u2026k_editable_template_text)");
                    return new WinkBubbleInfo("winkTemplateTextList", string7, 2, 0L, null, null, 56, null);
                }
                return null;
            case -385653636:
                if (name.equals("winkEnhanceTip")) {
                    String string8 = context.getString(R.string.f239327m6);
                    Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.stri\u2026nk_editor_enhance_bubble)");
                    return new WinkBubbleInfo("winkEnhanceTip", string8, 0, 0L, null, null, 56, null);
                }
                return null;
            case -312140962:
                if (name.equals("winEmotionSticker")) {
                    String string9 = context.getString(R.string.f239667n3);
                    Intrinsics.checkNotNullExpressionValue(string9, "context.getString(R.stri\u2026.wink_editor_qq_emoticon)");
                    return new WinkBubbleInfo("winEmotionSticker", string9, 2, 0L, null, null, 56, null);
                }
                return null;
            case -218639307:
                if (name.equals("publishCoverSticker")) {
                    String string10 = context.getString(R.string.f240497pb);
                    Intrinsics.checkNotNullExpressionValue(string10, "context.getString(R.stri\u2026blish_cover_guide_bubble)");
                    return new WinkBubbleInfo("publishCoverSticker", string10, 0, 0L, null, null, 60, null);
                }
                return null;
            case 481168871:
                if (name.equals("winkTraceSticker")) {
                    String string11 = context.getString(R.string.f215475vp);
                    Intrinsics.checkNotNullExpressionValue(string11, "context.getString(R.stri\u2026qqwink_cut_trace_sticker)");
                    return new WinkBubbleInfo("winkTraceSticker", string11, 0, 0L, null, null, 60, null);
                }
                return null;
            case 953342205:
                if (name.equals("winkEffectFace")) {
                    String string12 = context.getString(R.string.f215335vb);
                    Intrinsics.checkNotNullExpressionValue(string12, "context.getString(R.stri\u2026cut_effect_face_guidance)");
                    return new WinkBubbleInfo("winkEffectFace", string12, 0, 0L, null, null, 60, null);
                }
                return null;
            case 1024700778:
                if (name.equals("winkSmartClip")) {
                    String string13 = context.getString(R.string.f215445vm);
                    Intrinsics.checkNotNullExpressionValue(string13, "context.getString(R.stri\u2026art_clip_close_popup_tip)");
                    return new WinkBubbleInfo("winkSmartClip", string13, 2, 0L, null, null, 56, null);
                }
                return null;
            case 1125807774:
                if (name.equals("winkQzonePhotoTemplate")) {
                    String string14 = context.getString(R.string.f240267op);
                    Intrinsics.checkNotNullExpressionValue(string14, "context.getString(R.stri\u2026.wink_new_photo_template)");
                    return new WinkBubbleInfo("winkQzonePhotoTemplate", string14, 2, 0L, null, null, 56, null);
                }
                return null;
            case 1131707545:
                if (name.equals("winkTemplateClip")) {
                    String string15 = context.getString(R.string.f239827ni);
                    Intrinsics.checkNotNullExpressionValue(string15, "context.getString(R.stri\u2026template_clip_tip_bubble)");
                    return new WinkBubbleInfo("winkTemplateClip", string15, 2, 0L, null, null, 56, null);
                }
                return null;
            case 1166039514:
                if (name.equals("winLyricSticker")) {
                    String string16 = context.getString(R.string.f239607mx);
                    Intrinsics.checkNotNullExpressionValue(string16, "context.getString(R.stri\u2026ric_sticker_guide_bubble)");
                    return new WinkBubbleInfo("winLyricSticker", string16, 0, 0L, null, null, 60, null);
                }
                return null;
            case 1656247662:
                if (name.equals("WinkAIElimination")) {
                    String string17 = context.getString(R.string.f240587pk);
                    Intrinsics.checkNotNullExpressionValue(string17, "context.getString(R.stri\u2026ne_ai_elimination_bubble)");
                    return new WinkBubbleInfo("WinkAIElimination", string17, 3, 0L, null, null, 56, null);
                }
                return null;
            case 2071129807:
                if (name.equals("publishTemplateCoverSticker")) {
                    String string18 = context.getString(R.string.f240557ph);
                    Intrinsics.checkNotNullExpressionValue(string18, "context.getString(R.stri\u2026sh_template_guide_bubble)");
                    return new WinkBubbleInfo("publishTemplateCoverSticker", string18, 0, 0L, null, null, 60, null);
                }
                return null;
            default:
                return null;
        }
    }

    private final String d(HashMap<String, String> params) {
        if (params == null) {
            return "";
        }
        boolean areEqual = Intrinsics.areEqual("0", params.get("edit_image_mode"));
        ms.a.a("BubbleShowHelper", "getNameWithParams isVideoMode = " + areEqual);
        if (!areEqual) {
            return "";
        }
        return "winEmotionSticker";
    }

    private final String g(HashMap<String, String> params) {
        String winkBubbleName = QzoneConfig.getWinkBubbleName(d(params));
        Intrinsics.checkNotNullExpressionValue(winkBubbleName, "getWinkBubbleName(getNameWithParams(params))");
        return winkBubbleName;
    }

    @Nullable
    public final WinkBubbleInfo e(@NotNull Context context, @NotNull String bubbleName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bubbleName, "bubbleName");
        WinkBubbleInfo c16 = c(context, bubbleName);
        if (c16 == null) {
            return null;
        }
        if (INSTANCE.e(c16)) {
            c16 = null;
        }
        return c16;
    }

    @Nullable
    public final WinkBubbleInfo f(@NotNull Context context, @Nullable HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        String g16 = g(params);
        ms.a.f("BubbleShowHelper", "getShowBubbleInfo :" + g16);
        return e(context, g16);
    }
}
