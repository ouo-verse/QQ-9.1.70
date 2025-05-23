package com.tencent.aio.api.list;

import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u00062\u00020\b2\u00020\t:\u0001\u0014J\b\u0010\u000b\u001a\u00020\nH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aio/api/list/IListUIOperationApi;", "Lcom/tencent/aio/api/list/e;", "Lcom/tencent/aio/api/refreshLoad/c;", "Lxs/a;", "Lcom/tencent/aio/api/list/IBounceScrollApi;", "Lcom/tencent/aio/api/list/IScreenRenderingApi;", "Lcom/tencent/aio/api/list/g;", "Lcom/tencent/aio/data/msglist/a;", "Lcom/tencent/aio/api/list/o;", "Lvs/a;", "Landroidx/recyclerview/widget/AIORecycleView;", "i", "", "position", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "G", "", "reset", "mode", "i0", "ArrangeMode", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface IListUIOperationApi extends e, com.tencent.aio.api.refreshLoad.c, xs.a, IBounceScrollApi, IScreenRenderingApi, g<com.tencent.aio.data.msglist.a>, o, vs.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/list/IListUIOperationApi$ArrangeMode;", "", "Companion", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ArrangeMode {
        public static final IPatchRedirector $redirector_ = null;
        public static final int Bottom_TO_TOP = 2;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int TOP_TO_BOTTOM = 1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/api/list/IListUIOperationApi$ArrangeMode$a;", "", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.aio.api.list.IListUIOperationApi$ArrangeMode$a, reason: from kotlin metadata */
        /* loaded from: classes3.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f69131a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20808);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f69131a = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(20813), (Class<?>) ArrangeMode.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f69131a;
            }
        }
    }

    @Nullable
    RecyclerView.ViewHolder G(int position);

    @NotNull
    AIORecycleView i();

    void i0(int mode);

    void reset();
}
