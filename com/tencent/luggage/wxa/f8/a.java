package com.tencent.luggage.wxa.f8;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b \b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u0004j\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!\u00a8\u0006\""}, d2 = {"Lcom/tencent/luggage/wxa/f8/a;", "", "", "a", "I", "b", "()I", "jsonVal", "<init>", "(Ljava/lang/String;II)V", "c", "d", "e", "f", "g", tl.h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "J", "K", "L", "M", "N", "O", "P", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public enum a {
    NORMAL(0),
    DARKEN(1),
    MULTIPLY(2),
    COLORBURN(3),
    LINEARBURN(4),
    DARKERCOLOR(5),
    LIGHTEN(6),
    SCREEN(7),
    COLODDODGE(8),
    LINEARDODGE(9),
    LIGHTCOLOR(10),
    OVERLAY(11),
    SOFTLIGHT(12),
    HARDLIGHT(13),
    VIVIDLIGHT(14),
    LINEARLIGHT(15),
    PINLIGHT(16),
    HARDMIX(17),
    DIFFERENCE(18),
    EXCLUSION(19),
    SUBTRACT(20),
    DIVIDE(21),
    HUE(22),
    SATURATION(23),
    LUMINOSITY(24);


    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int jsonVal;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/wxa/f8/a$a;", "", "", "typeInt", "Lcom/tencent/luggage/wxa/f8/a;", "a", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.luggage.wxa.f8.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final a a(int typeInt) {
            boolean z16;
            for (a aVar : a.values()) {
                if (typeInt == aVar.getJsonVal()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return aVar;
                }
            }
            return null;
        }
    }

    a(int i3) {
        this.jsonVal = i3;
    }

    /* renamed from: b, reason: from getter */
    public final int getJsonVal() {
        return this.jsonVal;
    }

    @JvmStatic
    @Nullable
    public static final a a(int i3) {
        return INSTANCE.a(i3);
    }
}
