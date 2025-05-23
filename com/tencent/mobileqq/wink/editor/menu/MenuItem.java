package com.tencent.mobileqq.wink.editor.menu;

import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'TEXT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/menu/MenuItem;", "", "title", "", "menuType", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/wink/editor/menu/MenuType;)V", "getMenuType", "()Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "getTitle", "()Ljava/lang/String;", "getIcon", "", "TO_VIDEO", "TO_IMAGE", "BACKGROUND", "CROP", "VIDEO_TEMPLATE", "CLIPPING", "TEMPLATE_CLIP", "FILTER", "TEXT", "STICKER", "STICKER_OLD", "EFFECT", "ENHANCE", "SUBTITLE", "TTS", "VIDEO_FIRST_TEMPLATE", "ADD_TEXT", "TEMPLATE_TEXT", "MOSAIC", "AI_ELIMINATION", "OPENING_ENDING", "AI_TEMPLATE", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class MenuItem {
    private static final /* synthetic */ MenuItem[] $VALUES;
    public static final MenuItem ADD_TEXT;
    public static final MenuItem AI_ELIMINATION;
    public static final MenuItem AI_TEMPLATE;
    public static final MenuItem EFFECT;
    public static final MenuItem ENHANCE;
    public static final MenuItem MOSAIC;
    public static final MenuItem OPENING_ENDING;
    public static final MenuItem STICKER;
    public static final MenuItem STICKER_OLD;
    public static final MenuItem SUBTITLE;
    public static final MenuItem TEMPLATE_TEXT;
    public static final MenuItem TEXT;
    public static final MenuItem TTS;
    public static final MenuItem VIDEO_FIRST_TEMPLATE;

    @NotNull
    private final MenuType menuType;

    @NotNull
    private final String title;
    public static final MenuItem TO_VIDEO = new MenuItem("TO_VIDEO", 0, "\u53d8\u89c6\u9891", MenuType.TO_VIDEO);
    public static final MenuItem TO_IMAGE = new MenuItem("TO_IMAGE", 1, "\u53d8\u56fe\u7247", MenuType.TO_IMAGE);
    public static final MenuItem BACKGROUND = new MenuItem("BACKGROUND", 2, "\u6362\u80cc\u666f", MenuType.BACKGROUND);
    public static final MenuItem CROP = new MenuItem("CROP", 3, "\u88c1\u526a", MenuType.CROP);
    public static final MenuItem VIDEO_TEMPLATE = new MenuItem("VIDEO_TEMPLATE", 4, "\u6a21\u677f", MenuType.VIDEO_TEMPLATE);
    public static final MenuItem CLIPPING = new MenuItem("CLIPPING", 5, "\u526a\u8f91", MenuType.CLIPPING);
    public static final MenuItem TEMPLATE_CLIP = new MenuItem("TEMPLATE_CLIP", 6, "\u526a\u8f91", MenuType.TEMPLATE_COLL_CLIP);
    public static final MenuItem FILTER = new MenuItem("FILTER", 7, "\u6ee4\u955c", MenuType.FILTER);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f320519a;

        static {
            int[] iArr = new int[MenuItem.values().length];
            try {
                iArr[MenuItem.TO_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MenuItem.TO_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MenuItem.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MenuItem.CROP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MenuItem.VIDEO_TEMPLATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MenuItem.CLIPPING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MenuItem.TEMPLATE_CLIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MenuItem.FILTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MenuItem.TEXT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MenuItem.STICKER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MenuItem.STICKER_OLD.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MenuItem.EFFECT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[MenuItem.ENHANCE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[MenuItem.SUBTITLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[MenuItem.TTS.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[MenuItem.VIDEO_FIRST_TEMPLATE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[MenuItem.ADD_TEXT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[MenuItem.TEMPLATE_TEXT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[MenuItem.MOSAIC.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[MenuItem.AI_ELIMINATION.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[MenuItem.OPENING_ENDING.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[MenuItem.AI_TEMPLATE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            f320519a = iArr;
        }
    }

    private static final /* synthetic */ MenuItem[] $values() {
        return new MenuItem[]{TO_VIDEO, TO_IMAGE, BACKGROUND, CROP, VIDEO_TEMPLATE, CLIPPING, TEMPLATE_CLIP, FILTER, TEXT, STICKER, STICKER_OLD, EFFECT, ENHANCE, SUBTITLE, TTS, VIDEO_FIRST_TEMPLATE, ADD_TEXT, TEMPLATE_TEXT, MOSAIC, AI_ELIMINATION, OPENING_ENDING, AI_TEMPLATE};
    }

    static {
        MenuType menuType = MenuType.TEXT;
        TEXT = new MenuItem("TEXT", 8, "\u6587\u5b57", menuType);
        STICKER = new MenuItem("STICKER", 9, "\u8d34\u7eb8", MenuType.STICKER);
        STICKER_OLD = new MenuItem("STICKER_OLD", 10, "\u8d34\u7eb8", MenuType.STICKER_OLD);
        EFFECT = new MenuItem("EFFECT", 11, "\u7279\u6548", MenuType.EFFECT);
        ENHANCE = new MenuItem("ENHANCE", 12, "\u753b\u8d28\u589e\u5f3a", MenuType.ENHANCE);
        SUBTITLE = new MenuItem("SUBTITLE", 13, "\u81ea\u52a8\u5b57\u5e55", MenuType.SUBTITLE);
        TTS = new MenuItem("TTS", 14, "\u6587\u672c\u6717\u8bfb", MenuType.TTS);
        VIDEO_FIRST_TEMPLATE = new MenuItem("VIDEO_FIRST_TEMPLATE", 15, "\u6a21\u677f", MenuType.VIDEO_FIRST_TEMPLATE);
        ADD_TEXT = new MenuItem("ADD_TEXT", 16, "\u6dfb\u52a0\u6587\u5b57", menuType);
        TEMPLATE_TEXT = new MenuItem("TEMPLATE_TEXT", 17, "\u6a21\u677f\u6587\u5b57", MenuType.TEMPLATE_TEXT_LIST);
        MOSAIC = new MenuItem("MOSAIC", 18, "\u9a6c\u8d5b\u514b", MenuType.MOSAIC);
        AI_ELIMINATION = new MenuItem("AI_ELIMINATION", 19, "AI\u6d88\u9664", MenuType.AI_ELIMINATION);
        OPENING_ENDING = new MenuItem("OPENING_ENDING", 20, "\u7247\u5934\u7247\u5c3e", MenuType.OPENING_ENDING);
        AI_TEMPLATE = new MenuItem("AI_TEMPLATE", 21, "AI\u6a21\u677f", MenuType.AI_TEMPLATE);
        $VALUES = $values();
    }

    MenuItem(String str, int i3, String str2, MenuType menuType) {
        this.title = str2;
        this.menuType = menuType;
    }

    public static MenuItem valueOf(String str) {
        return (MenuItem) Enum.valueOf(MenuItem.class, str);
    }

    public static MenuItem[] values() {
        return (MenuItem[]) $VALUES.clone();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        if (com.tencent.mobileqq.wink.editor.menu.v.b() != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return com.tencent.mobileqq.R.drawable.m4p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return com.tencent.mobileqq.R.drawable.m4q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dc, code lost:
    
        if (com.tencent.mobileqq.wink.editor.menu.v.b() != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
    
        return com.tencent.mobileqq.R.drawable.m48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return com.tencent.mobileqq.R.drawable.m49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e3, code lost:
    
        if (com.tencent.mobileqq.wink.editor.menu.v.b() != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ed, code lost:
    
        if (com.tencent.mobileqq.wink.editor.menu.v.b() != false) goto L64;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001d. Please report as an issue. */
    @DrawableRes
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getIcon() {
        switch (a.f320519a[ordinal()]) {
            case 1:
                if (v.b()) {
                    return R.drawable.m4x;
                }
                return R.drawable.m4w;
            case 2:
                if (v.b()) {
                    return R.drawable.m4k;
                }
                return R.drawable.m4j;
            case 3:
                return R.drawable.m47;
            case 4:
                if (v.b()) {
                    return R.drawable.m4a;
                }
                return R.drawable.m4_;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                if (v.b()) {
                    return R.drawable.m4i;
                }
                return R.drawable.m4h;
            case 9:
                if (!v.b()) {
                    return R.drawable.m4t;
                }
                return R.drawable.m4u;
            case 10:
                if (v.b()) {
                    return R.drawable.m4m;
                }
                return R.drawable.m4l;
            case 11:
                if (v.b()) {
                    return R.drawable.m4m;
                }
                return R.drawable.m4l;
            case 12:
                if (v.b()) {
                    return R.drawable.m4c;
                }
                return R.drawable.m4b;
            case 13:
                if (v.b()) {
                    return R.drawable.m4e;
                }
                return R.drawable.m4d;
            case 14:
                if (v.b()) {
                    return R.drawable.m4o;
                }
                return R.drawable.m4n;
            case 15:
                return R.drawable.m4v;
            case 16:
                break;
            case 17:
                if (!v.b()) {
                    return R.drawable.m46;
                }
                return R.drawable.m4u;
            case 18:
                if (v.b()) {
                    return R.drawable.m4s;
                }
                return R.drawable.m4r;
            case 19:
                if (v.b()) {
                    return R.drawable.op9;
                }
                return R.drawable.op8;
            case 20:
                return R.drawable.f162046op1;
            case 21:
                if (v.b()) {
                    return R.drawable.f162049op4;
                }
                return R.drawable.f162048op3;
            case 22:
                return R.drawable.oot;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final MenuType getMenuType() {
        return this.menuType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
