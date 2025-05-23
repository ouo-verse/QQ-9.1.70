package com.tencent.mobileqq.aio.msglist.holder.skin.padding;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\"\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0017\u001a\u0004\b\f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/g;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "a", "", "I", "d", "()I", "setPaddingLeft", "(I)V", NodeProps.PADDING_LEFT, "b", "e", "setPaddingRight", NodeProps.PADDING_RIGHT, "c", "f", "setPaddingTop", NodeProps.PADDING_TOP, "setPaddingBottom", NodeProps.PADDING_BOTTOM, "", UserInfo.SEX_FEMALE, "()F", "setBubbleHeight", "(F)V", "bubbleHeight", "g", "setWaveHeight", "waveHeight", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class g extends com.tencent.mobileqq.aio.msglist.holder.skin.padding.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int paddingLeft;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int paddingRight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int paddingTop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int paddingBottom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float bubbleHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float waveHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/g$a;", "", "", "b", UserInfo.SEX_FEMALE, "a", "()F", "NORMAL_BUBBLE_HEIGHT", "c", "VAS_BUBBLE_HEIGHT", "d", "NORMAL_WAVE_HEIGHT", "e", "VAS_WAVE_HEIGHT", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f192450a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final float NORMAL_BUBBLE_HEIGHT;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static final float VAS_BUBBLE_HEIGHT;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static final float NORMAL_WAVE_HEIGHT;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static final float VAS_WAVE_HEIGHT;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48989);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
                return;
            }
            f192450a = new a();
            NORMAL_BUBBLE_HEIGHT = 42.0f;
            VAS_BUBBLE_HEIGHT = 68.0f;
            NORMAL_WAVE_HEIGHT = 42.0f;
            VAS_WAVE_HEIGHT = 52.0f;
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return NORMAL_BUBBLE_HEIGHT;
        }

        public final float b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return NORMAL_WAVE_HEIGHT;
        }

        public final float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
            }
            return VAS_BUBBLE_HEIGHT;
        }

        public final float d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
            }
            return VAS_WAVE_HEIGHT;
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.skin.padding.a
    @NotNull
    public com.tencent.mobileqq.aio.msglist.holder.skin.padding.a a(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.aio.msglist.holder.skin.padding.a) iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (m.f194167a.c(msgItem)) {
            this.paddingLeft = 0;
            a aVar = a.f192450a;
            this.bubbleHeight = aVar.a();
            this.waveHeight = aVar.b();
        } else {
            this.paddingLeft = a.b.f192418a.d();
            a aVar2 = a.f192450a;
            this.bubbleHeight = aVar2.c();
            this.waveHeight = aVar2.d();
        }
        return this;
    }

    public final float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.bubbleHeight;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.paddingBottom;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.paddingLeft;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.paddingRight;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.paddingTop;
    }

    public final float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        return this.waveHeight;
    }
}
