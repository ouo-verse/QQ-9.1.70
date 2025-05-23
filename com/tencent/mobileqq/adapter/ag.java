package com.tencent.mobileqq.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.ag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.widget.SelectAccountView;
import com.tencent.mobileqq.widget.bm;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B-\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0017J\u0012\u0010\u0015\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tJ\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010!R\u0016\u0010+\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010-\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010!R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/adapter/ag;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/adapter/ag$a;", "Landroid/view/View;", "view", "", com.tencent.luggage.wxa.c8.c.G, "", "u0", "", "accountDataList", "w0", "position", "", "getItemId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "s0", "holder", "n0", "v0", "getItemCount", "Lcom/tencent/mobileqq/widget/bm$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/bm$c;", "mOnAccountClickListener", "Landroid/view/View$OnTouchListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnTouchListener;", "mOnTouchListener", "", "D", "Z", "mShowLoginBtn", "", "", "E", "Ljava/util/List;", "mAccountList", UserInfo.SEX_FEMALE, "mUseAccountInfoList", "G", "mIsItemClickable", "H", "mUseAvatarUrlDrawableCache", "Landroid/os/Handler;", "I", "Landroid/os/Handler;", "mHandler", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "J", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "sDecodeHandler", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/widget/bm$c;Landroid/view/View$OnTouchListener;Z)V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ag extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View.OnTouchListener mOnTouchListener;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean mShowLoginBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<Object> mAccountList;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mUseAccountInfoList;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsItemClickable;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mUseAvatarUrlDrawableCache;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final DownloadParams.DecodeHandler sDecodeHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bm.c mOnAccountClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/adapter/ag$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/widget/SelectAccountView;", "E", "Lcom/tencent/mobileqq/widget/SelectAccountView;", "l", "()Lcom/tencent/mobileqq/widget/SelectAccountView;", "mSelectAccountView", "<init>", "(Lcom/tencent/mobileqq/widget/SelectAccountView;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final SelectAccountView mSelectAccountView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull SelectAccountView mSelectAccountView) {
            super(mSelectAccountView);
            Intrinsics.checkNotNullParameter(mSelectAccountView, "mSelectAccountView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mSelectAccountView);
            } else {
                this.mSelectAccountView = mSelectAccountView;
            }
        }

        @NotNull
        public final SelectAccountView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SelectAccountView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mSelectAccountView;
        }
    }

    public ag(@NotNull List<?> accountDataList, @NotNull bm.c mOnAccountClickListener, @NotNull View.OnTouchListener mOnTouchListener, boolean z16) {
        Intrinsics.checkNotNullParameter(accountDataList, "accountDataList");
        Intrinsics.checkNotNullParameter(mOnAccountClickListener, "mOnAccountClickListener");
        Intrinsics.checkNotNullParameter(mOnTouchListener, "mOnTouchListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, accountDataList, mOnAccountClickListener, mOnTouchListener, Boolean.valueOf(z16));
            return;
        }
        this.mOnAccountClickListener = mOnAccountClickListener;
        this.mOnTouchListener = mOnTouchListener;
        this.mShowLoginBtn = z16;
        this.mAccountList = new ArrayList();
        this.mUseAccountInfoList = true;
        this.mIsItemClickable = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        w0(accountDataList);
        this.sDecodeHandler = new DownloadParams.DecodeHandler() { // from class: com.tencent.mobileqq.adapter.ab
            @Override // com.tencent.image.DownloadParams.DecodeHandler
            public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
                Bitmap t06;
                t06 = ag.t0(downloadParams, bitmap);
                return t06;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
    public static final void o0(String uin, ag this$0, final a holder) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? accountNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getAccountNickName(appInterface, uin);
        objectRef.element = accountNickName;
        if (TextUtils.isEmpty((CharSequence) accountNickName) || Intrinsics.areEqual(objectRef.element, uin)) {
            objectRef.element = ((IContactUtils) QRoute.api(IContactUtils.class)).getFriendNickName(appInterface, uin);
        }
        this$0.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.adapter.af
            @Override // java.lang.Runnable
            public final void run() {
                ag.p0(ag.a.this, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void p0(a holder, Ref.ObjectRef nickname) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(nickname, "$nickname");
        SelectAccountView l3 = holder.l();
        T nickname2 = nickname.element;
        Intrinsics.checkNotNullExpressionValue(nickname2, "nickname");
        l3.c((String) nickname2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(ag this$0, Object accountData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(accountData, "$accountData");
        this$0.mOnAccountClickListener.a(accountData);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(ag this$0, Object accountData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(accountData, "$accountData");
        this$0.mOnAccountClickListener.a(accountData);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap t0(DownloadParams downloadParams, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Object obj = downloadParams.tag;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            if (iArr.length == 2) {
                float q16 = com.tencent.mobileqq.utils.ah.q();
                if (q16 < 0.01f) {
                    q16 = 1.0f;
                }
                int i3 = (int) (iArr[0] / q16);
                iArr[0] = i3;
                int i16 = (int) (iArr[1] / q16);
                iArr[1] = i16;
                return BaseImageUtil.getCircleFaceBitmap(bitmap, i3, i16);
            }
            return bitmap;
        }
        return bitmap;
    }

    private final void u0(View view, int pos) {
        if (!(view instanceof SelectAccountView)) {
            return;
        }
        int num_backgournd_icon = getNUM_BACKGOURND_ICON();
        if (num_backgournd_icon == 1) {
            ((SelectAccountView) view).setBgType(0);
            return;
        }
        if (pos == 0) {
            ((SelectAccountView) view).setBgType(1);
        } else if (pos == num_backgournd_icon - 1) {
            ((SelectAccountView) view).setBgType(3);
        } else {
            ((SelectAccountView) view).setBgType(2);
        }
    }

    private final void w0(List<?> accountDataList) {
        this.mAccountList.clear();
        for (Object obj : accountDataList) {
            if (obj != null && ((obj instanceof AccountInfo) | (obj instanceof com.tencent.mobileqq.login.account.a))) {
                this.mAccountList.add(obj);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mAccountList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, position)).longValue();
        }
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        SelectAccountView l3 = holder.l();
        l3.getContext();
        final Object obj = this.mAccountList.get(position);
        if (obj instanceof AccountInfo) {
            AccountInfo accountInfo = (AccountInfo) obj;
            String uin = accountInfo.getMaskUin();
            SelectAccountView l16 = holder.l();
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            l16.d(uin);
            String nickname = accountInfo.getMaskNick();
            SelectAccountView l17 = holder.l();
            Intrinsics.checkNotNullExpressionValue(nickname, "nickname");
            l17.c(nickname);
            SelectAccountView l18 = holder.l();
            String imgUrl = accountInfo.getImgUrl();
            Intrinsics.checkNotNullExpressionValue(imgUrl, "accountData.imgUrl");
            l18.b(imgUrl);
        } else if (obj instanceof com.tencent.mobileqq.login.account.a) {
            final String f16 = ((com.tencent.mobileqq.login.account.a) obj).f();
            holder.l().d(f16);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.adapter.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ag.o0(f16, this, holder);
                }
            }, 48, null, true);
            holder.l().a(f16);
        }
        u0(l3, position);
        l3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.adapter.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ag.q0(ag.this, obj, view);
            }
        });
        l3.setOnTouchListener(this.mOnTouchListener);
        QUIButton qUIButton = (QUIButton) l3.findViewById(R.id.f166147yu4);
        if (this.mShowLoginBtn) {
            qUIButton.setVisibility(0);
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.adapter.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ag.r0(ag.this, obj, view);
                }
            });
            qUIButton.setOnTouchListener(this.mOnTouchListener);
        } else {
            qUIButton.setVisibility(8);
        }
        if (this.mIsItemClickable) {
            l3.setBackgroundResource(R.drawable.f161303ue);
        } else {
            l3.setBackgroundResource(R.drawable.qui_common_bg_top_light_bg);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168822gy4, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026_num_item, parent, false)");
        return new a((SelectAccountView) inflate);
    }

    public final void v0(@NotNull List<?> accountDataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) accountDataList);
            return;
        }
        Intrinsics.checkNotNullParameter(accountDataList, "accountDataList");
        w0(accountDataList);
        notifyDataSetChanged();
        this.mUseAvatarUrlDrawableCache = true;
    }
}
