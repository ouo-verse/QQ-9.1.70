package com.tencent.mobileqq.wink.inspirationlibrary.part;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils;", "", "a", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkInspirationTemplateUtils {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion;", "", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "size", "", "f", "b", "templateSize", "", "e", "width", "a", "c", "DEFAULT_SCREEN_WIDTH_DP", UserInfo.SEX_FEMALE, "DEFAULT_TEMPLATE_HEIGHT_DP", "DEFAULT_TEMPLATE_WIDTH_DP", "EXP_BIG_TEMPLATE_HEIGHT_DP", "EXP_BIG_TEMPLATE_WIDTH_DP", "EXP_NORMAL_TEMPLATE_HEIGHT_DP", "EXP_NORMAL_TEMPLATE_WIDTH_DP", "TEMPLATE_DESC_HEIGHT_DP", "<init>", "()V", "SIZE", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "", "(Ljava/lang/String;I)V", "DEFAULT", "EXP_NORMAL", "EXP_BIG", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public enum SIZE {
            DEFAULT,
            EXP_NORMAL,
            EXP_BIG
        }

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f323000a;

            static {
                int[] iArr = new int[SIZE.values().length];
                try {
                    iArr[SIZE.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SIZE.EXP_NORMAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SIZE.EXP_BIG.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f323000a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float b(SIZE size) {
            int i3 = a.f323000a[size.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return 299.0f;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return 195.0f;
            }
            return 176.0f;
        }

        public static /* synthetic */ int d(Companion companion, SIZE size, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                size = SIZE.DEFAULT;
            }
            return companion.c(size);
        }

        private final float f(SIZE size) {
            int i3 = a.f323000a[size.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return 168.0f;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return 110.0f;
            }
            return 98.0f;
        }

        public final int a(int width, @NotNull SIZE templateSize) {
            Intrinsics.checkNotNullParameter(templateSize, "templateSize");
            return (width * ViewUtils.dpToPx(b(templateSize))) / ViewUtils.dpToPx(f(templateSize));
        }

        public final int c(@NotNull SIZE templateSize) {
            Intrinsics.checkNotNullParameter(templateSize, "templateSize");
            int e16 = e(templateSize);
            if (templateSize == SIZE.EXP_BIG) {
                return a(e16, templateSize);
            }
            return a(e16, templateSize) + ViewUtils.dpToPx(34.0f);
        }

        public final int e(@NotNull SIZE templateSize) {
            Intrinsics.checkNotNullParameter(templateSize, "templateSize");
            return (ViewUtils.getScreenWidth() * ViewUtils.dpToPx(f(templateSize))) / ViewUtils.dpToPx(375.0f);
        }

        Companion() {
        }
    }
}
