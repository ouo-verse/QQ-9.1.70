package com.tencent.mobileqq.guild.client.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import ig1.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u0018\u0010\u001fB+\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b\u0018\u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/client/widget/GuildClientIdentityView;", "Landroid/widget/FrameLayout;", "", "f", "g", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "identity", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "c", "", "identityDes", "b", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textIdentity", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "imageIdentity", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildClientIdentityView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView textIdentity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView imageIdentity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/client/widget/GuildClientIdentityView$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "b", "", "c", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String a(@NotNull IGProUserInfo userInfo) {
            IGProClientIdentityByteInfo identityBytes;
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            IGProClientIdentityInfo clientIdentity = userInfo.getClientIdentity();
            if (clientIdentity == null || (identityBytes = clientIdentity.getIdentityBytes()) == null) {
                return "";
            }
            return String.valueOf(identityBytes.getClientId());
        }

        @JvmStatic
        @Nullable
        public final IGProIdentityInfo b(@NotNull IGProUserInfo userInfo) {
            IGProClientIdentityByteInfo identityBytes;
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            IGProClientIdentityInfo clientIdentity = userInfo.getClientIdentity();
            if (clientIdentity == null || (identityBytes = clientIdentity.getIdentityBytes()) == null) {
                return null;
            }
            for (IGProIdentityInfo iGProIdentityInfo : identityBytes.getIdentityList()) {
                if (iGProIdentityInfo.getType() == 0 || iGProIdentityInfo.getType() == 1 || iGProIdentityInfo.getIdentityType() == 2) {
                    return iGProIdentityInfo;
                }
            }
            return null;
        }

        @NotNull
        public final String c(@NotNull IGProUserInfo userInfo) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            IGProClientIdentityInfo clientIdentity = userInfo.getClientIdentity();
            if (clientIdentity == null) {
                return "";
            }
            String desc = clientIdentity.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "clientIdentity.desc");
            return desc;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildClientIdentityView(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmStatic
    @NotNull
    public static final String d(@NotNull IGProUserInfo iGProUserInfo) {
        return INSTANCE.a(iGProUserInfo);
    }

    @JvmStatic
    @Nullable
    public static final IGProIdentityInfo e(@NotNull IGProUserInfo iGProUserInfo) {
        return INSTANCE.b(iGProUserInfo);
    }

    private final void f() {
        View findViewById = findViewById(R.id.tyc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.client_identity_text)");
        this.textIdentity = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tyb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.client_identity_image)");
        this.imageIdentity = (ImageView) findViewById2;
    }

    private final void g() {
        setVisibility(8);
        TextView textView = this.textIdentity;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textIdentity");
            textView = null;
        }
        textView.setVisibility(8);
        ImageView imageView2 = this.imageIdentity;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIdentity");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.widget.TextView] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@Nullable IGProIdentityInfo identity) {
        boolean z16;
        boolean z17;
        boolean isBlank;
        g();
        if (identity == null) {
            return;
        }
        String value = identity.getValue();
        if (value != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(value);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    byte[] plateData = identity.getPlateData();
                    Intrinsics.checkNotNullExpressionValue(plateData, "identity.plateData");
                    if (plateData.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return;
                    }
                }
                if (identity.getIdentityType() != 2) {
                    return;
                }
                ImageView imageView = null;
                if (identity.getType() == 0) {
                    TextView textView = this.textIdentity;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("textIdentity");
                        textView = null;
                    }
                    textView.setText(identity.getValue());
                    setVisibility(0);
                    ?? r56 = this.textIdentity;
                    if (r56 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("textIdentity");
                    } else {
                        imageView = r56;
                    }
                    imageView.setVisibility(0);
                    return;
                }
                if (identity.getType() == 1) {
                    String value2 = identity.getValue();
                    Intrinsics.checkNotNullExpressionValue(value2, "identity.value");
                    String a16 = a.a(value2);
                    ImageView imageView2 = this.imageIdentity;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("imageIdentity");
                        imageView2 = null;
                    }
                    u.p(a16, imageView2);
                    setVisibility(0);
                    ImageView imageView3 = this.imageIdentity;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("imageIdentity");
                    } else {
                        imageView = imageView3;
                    }
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
        if (identity.getIdentityType() != 2) {
        }
    }

    public final void b(@Nullable String identityDes) {
        boolean z16;
        g();
        if (identityDes != null && identityDes.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            TextView textView = this.textIdentity;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textIdentity");
                textView = null;
            }
            textView.setText(identityDes);
            setVisibility(0);
            TextView textView3 = this.textIdentity;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textIdentity");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(0);
        }
    }

    public final void c(@NotNull IGProUserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        b(INSTANCE.c(userInfo));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildClientIdentityView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildClientIdentityView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildClientIdentityView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.ejf, this);
        f();
    }
}
