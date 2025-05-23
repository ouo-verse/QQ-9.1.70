package com.tencent.mobileqq.multiforward;

import android.content.Context;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.api.help.d;
import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.background.FullBackgroundVB;
import com.tencent.mobileqq.aio.helper.AIOChatBackgroundHelper;
import com.tencent.mobileqq.aio.helper.DynamicPicHelper;
import com.tencent.mobileqq.aio.helper.MsgRelevantHelper;
import com.tencent.mobileqq.aio.helper.ad;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.multiforward.title.MultiForwardTitleVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.multiforward.api.IMultiForwardHelperApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/multiforward/d;", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/mobileqq/aio/msg/service/AIOMsgService;", "a", "Lcom/tencent/mobileqq/aio/b;", "b", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "getPanelFactory", "", "isDebugModel", "Lcom/tencent/aio/api/factory/d;", "buildReserve1Level", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d implements g {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/multiforward/d$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/mobileqq/multiforward/EmptyInputBarVB;", h.F, "Lcom/tencent/mobileqq/multiforward/title/MultiForwardTitleVB;", "i", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.aio.api.factory.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return f.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return f.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return f.a.d(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<? extends at.e, ? extends TopTipViewState> buildTopTipVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return f.a.f(this);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.aio.api.b) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return f.a.g(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public EmptyInputBarVB buildInputVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EmptyInputBarVB) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new EmptyInputBarVB();
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public MultiForwardTitleVB buildTitleVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MultiForwardTitleVB) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new MultiForwardTitleVB();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/multiforward/d$b", "Lcom/tencent/aio/api/factory/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.aio.api.factory.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.a
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new FullBackgroundVB();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/multiforward/d$c", "Lcom/tencent/aio/api/help/d;", "", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelper", "()[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements com.tencent.aio.api.help.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
        @Nullable
        public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper(@NotNull com.tencent.aio.api.help.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? d.a.b(this, aVar) : (com.tencent.aio.main.businesshelper.h[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @Nullable
        public Map<String, Function0<com.tencent.aio.main.businesshelper.h>> getLifeCycleHelperCreator(@NotNull com.tencent.aio.api.help.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Map) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            }
            return d.a.c(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @NotNull
        public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new com.tencent.aio.main.businesshelper.e[0] : (com.tencent.aio.main.businesshelper.e[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
        @Nullable
        public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(@NotNull com.tencent.aio.api.help.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Map) iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            }
            return d.a.f(this, aVar);
        }

        @Override // com.tencent.aio.api.help.d
        @NotNull
        public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper() {
            Object[] plus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.main.businesshelper.h[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            plus = ArraysKt___ArraysJvmKt.plus((Object[]) new com.tencent.aio.main.businesshelper.h[]{new t(), new ad(), new MsgRelevantHelper(), new com.tencent.mobileqq.multiforward.helper.b(), new AIOChatBackgroundHelper(), new DynamicPicHelper()}, (Object[]) ((IMultiForwardHelperApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMultiForwardHelperApi.class)).getLifeCycleHelper());
            return (com.tencent.aio.main.businesshelper.h[]) plus;
        }

        @Override // com.tencent.aio.api.help.d
        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
        @Nullable
        public com.tencent.aio.main.businesshelper.e[] getNormalHelper(@NotNull com.tencent.aio.api.help.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? d.a.e(this, aVar) : (com.tencent.aio.main.businesshelper.e[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/multiforward/d$d", "Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/mobileqq/aio/factory/e;", h.F, "Lcom/tencent/mobileqq/multiforward/msglist/b;", "i", "Lcom/tencent/mobileqq/aio/factory/f;", "j", "Landroid/content/Context;", "context", "", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multiforward.d$d, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C8112d implements j {
        static IPatchRedirector $redirector_;

        C8112d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return j.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int c(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context)).intValue();
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ) + ((int) MobileQQ.sMobileQQ.getResources().getDimension(R.dimen.f158287c11));
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return j.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int e(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context)).intValue();
            }
            return j.a.c(this, context);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (com.tencent.aio.api.b) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return j.a.e(this);
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.aio.factory.e b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.aio.factory.e) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new com.tencent.mobileqq.aio.factory.e(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.multiforward.msglist.b g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.multiforward.msglist.b) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new com.tencent.mobileqq.multiforward.msglist.b();
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.aio.factory.f f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.aio.factory.f) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return com.tencent.mobileqq.aio.factory.f.f188791a;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/multiforward/d$e", "Lcom/tencent/aio/api/factory/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve1UIState;", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements com.tencent.aio.api.factory.d {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.d
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve1UIState> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new MultiforwardReserveVB();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/multiforward/d$f", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "", "panelId", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class f extends com.tencent.aio.part.root.panel.mvx.config.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.part.root.panel.mvx.config.a
        @Nullable
        public com.tencent.aio.part.root.panel.mvx.config.b b(int panelId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.part.root.panel.mvx.config.b) iPatchRedirector.redirect((short) 2, (Object) this, panelId);
            }
            return null;
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AIOMsgService buildAIOMsgService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgService) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AIOMsgService.f190196a;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.b buildActivityJumpService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.aio.b.f188187a;
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.base.log.f buildAIOLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.aio.base.log.f) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return g.a.a(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.f buildBusinessLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.factory.f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.aio.api.factory.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (j) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new C8112d();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.c buildPanelArea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.aio.api.factory.c) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return g.a.d(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.d buildReserve1Level() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.aio.api.factory.d) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new e();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.aio.api.factory.e) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return g.a.f(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public dt.b getBottomDialogFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (dt.b) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return g.a.g(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.aio.part.root.panel.mvx.config.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new f();
    }

    @Override // com.tencent.aio.api.factory.g
    public boolean isDebugModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return com.tencent.qqnt.util.b.f362976b.isDebugVersion();
    }
}
