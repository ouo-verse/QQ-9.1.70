package com.tencent.luggage.wxa.n5;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.f5.a;
import com.tencent.luggage.wxa.h5.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mobileqq.R;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010!\u001a\u00020\u001f\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J&\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0018H\u0002R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010(R&\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u001b0*j\b\u0012\u0004\u0012\u00020\u001b`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010,R\u0016\u0010/\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/luggage/wxa/n5/c;", "", "", "bizUsername", "", "b", "appId", "a", "nickname", "c", PushClientConstants.TAG_CLASS_NAME, "d", "g", "k", "j", "i", h.F, "l", "f", "e", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/luggage/wxa/g5/c;", "result", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "Lcom/tencent/luggage/wxa/sb/d;", "items", "exampleTitle", "show", "Lcom/tencent/luggage/wxa/m5/a;", "Lcom/tencent/luggage/wxa/m5/a;", "mSettingUIAction", "Ljava/lang/String;", "mBizUsername", "mAppId", "mNickname", "mPresenterClassName", "Lcom/tencent/luggage/wxa/f5/a;", "Lcom/tencent/luggage/wxa/f5/a;", "mAdapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mDataList", "Landroid/view/View;", "mRootView", "Lcom/tencent/luggage/wxa/h5/a;", "Lcom/tencent/luggage/wxa/h5/a;", "presenter", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "mSwitchBtn", "Lcom/tencent/luggage/wxa/g6/a;", "Lcom/tencent/luggage/wxa/g6/a;", "mContainerAction", "<init>", "(Lcom/tencent/luggage/wxa/m5/a;)V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.m5.a mSettingUIAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public String mBizUsername;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public String mAppId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public String mNickname;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public String mPresenterClassName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.f5.a mAdapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public ArrayList mDataList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public View mRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.h5.a presenter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public MMSwitchBtn mSwitchBtn;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.g6.a mContainerAction;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {
        public b() {
            super(1);
        }

        public final void a(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            c.this.mSettingUIAction.e().setResult(-1, intent);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Intent) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n5.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6501c implements a.InterfaceC6192a {
        public C6501c() {
        }

        @Override // com.tencent.luggage.wxa.f5.a.InterfaceC6192a
        public void a(com.tencent.luggage.wxa.sb.d item, boolean z16) {
            Intrinsics.checkNotNullParameter(item, "item");
            com.tencent.luggage.wxa.h5.a aVar = c.this.presenter;
            if (aVar != null) {
                aVar.a(item, z16);
            }
        }

        @Override // com.tencent.luggage.wxa.f5.a.InterfaceC6192a
        public boolean a(com.tencent.luggage.wxa.sb.d item) {
            Intrinsics.checkNotNullParameter(item, "item");
            com.tencent.luggage.wxa.h5.a aVar = c.this.presenter;
            if (aVar != null) {
                return aVar.a(item);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements MMSwitchBtn.ISwitch {
        public d() {
        }

        @Override // com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch
        public final void onStatusChange(boolean z16) {
            Boolean bool;
            boolean z17;
            boolean z18;
            Object[] objArr = new Object[1];
            MMSwitchBtn mMSwitchBtn = c.this.mSwitchBtn;
            if (mMSwitchBtn != null) {
                bool = Boolean.valueOf(mMSwitchBtn.isCheck());
            } else {
                bool = null;
            }
            objArr[0] = bool;
            w.d("Luggage.STANDALONE.WxaSubscribeMsgLogicImpl", "alvinluo SubscribeMsg onSwitchChanged %s", objArr);
            com.tencent.luggage.wxa.h5.a aVar = c.this.presenter;
            if (aVar != null) {
                MMSwitchBtn mMSwitchBtn2 = c.this.mSwitchBtn;
                if (mMSwitchBtn2 != null) {
                    z18 = mMSwitchBtn2.isCheck();
                } else {
                    z18 = false;
                }
                aVar.a(z18);
            }
            MMSwitchBtn mMSwitchBtn3 = c.this.mSwitchBtn;
            if (mMSwitchBtn3 != null && mMSwitchBtn3.isCheck()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                c.this.a(true);
            } else {
                c.this.a(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements b.a {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f135425a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.g5.c f135426b;

            public a(c cVar, com.tencent.luggage.wxa.g5.c cVar2) {
                this.f135425a = cVar;
                this.f135426b = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f135425a.a(this.f135426b);
            }
        }

        public e() {
        }

        @Override // com.tencent.luggage.wxa.h5.b.a
        public void a() {
            w.b("Luggage.STANDALONE.WxaSubscribeMsgLogicImpl", "alvinluo getSubscribeMsgList ERROR");
        }

        @Override // com.tencent.luggage.wxa.h5.b.a
        public void a(com.tencent.luggage.wxa.g5.c data) {
            Intrinsics.checkNotNullParameter(data, "data");
            w.d("Luggage.STANDALONE.WxaSubscribeMsgLogicImpl", "alvinluo getSubscribeMsgList onSuccess");
            c.this.mContainerAction.runOnUiThread(new a(c.this, data));
        }
    }

    public c(@NotNull com.tencent.luggage.wxa.m5.a mSettingUIAction) {
        Intrinsics.checkNotNullParameter(mSettingUIAction, "mSettingUIAction");
        this.mSettingUIAction = mSettingUIAction;
        this.mBizUsername = "";
        this.mAppId = "";
        this.mNickname = "";
        this.mPresenterClassName = "";
        this.mDataList = new ArrayList();
        this.mContainerAction = mSettingUIAction.e();
    }

    public void e() {
        com.tencent.luggage.wxa.h5.a aVar = this.presenter;
        if (aVar != null) {
            aVar.a(this.mBizUsername, this.mAppId, new e());
        }
    }

    public void f() {
        a();
    }

    public void g() {
        com.tencent.luggage.wxa.h5.a aVar = this.presenter;
        if (aVar != null) {
            aVar.a(this.mContainerAction);
        }
    }

    public void h() {
        com.tencent.luggage.wxa.h5.a aVar = this.presenter;
        if (aVar != null) {
            aVar.b(this.mContainerAction);
        }
        w.d("Luggage.STANDALONE.WxaSubscribeMsgLogicImpl", "alvinluo onDestroy");
    }

    public void i() {
        com.tencent.luggage.wxa.h5.a aVar = this.presenter;
        if (aVar != null) {
            aVar.c(this.mContainerAction);
        }
    }

    public void j() {
        com.tencent.luggage.wxa.h5.a aVar = this.presenter;
        if (aVar != null) {
            aVar.d(this.mContainerAction);
        }
    }

    public void k() {
        com.tencent.luggage.wxa.h5.a aVar = this.presenter;
        if (aVar != null) {
            aVar.e(this.mContainerAction);
        }
    }

    public void l() {
        com.tencent.luggage.wxa.h5.a aVar = this.presenter;
        if (aVar != null) {
            aVar.f(this.mContainerAction);
        }
    }

    public void b(String bizUsername) {
        Intrinsics.checkNotNullParameter(bizUsername, "bizUsername");
        this.mBizUsername = bizUsername;
    }

    public void c(String nickname) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        this.mNickname = nickname;
    }

    public void d(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        this.mPresenterClassName = className;
    }

    public void b() {
        Context context = this.mContainerAction.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mContainerAction.getContext()");
        this.mAdapter = new com.tencent.luggage.wxa.f5.a(context, new C6501c());
    }

    public void c() {
        w.a("Luggage.STANDALONE.WxaSubscribeMsgLogicImpl", "alvinluo SubscribeMsgManager username: %s, nickname: %s", this.mBizUsername, this.mNickname);
        e();
    }

    public void d() {
        if (!(this.mPresenterClassName.length() == 0)) {
            try {
                this.presenter = (com.tencent.luggage.wxa.h5.a) Class.forName(this.mPresenterClassName).newInstance();
                return;
            } catch (Exception e16) {
                throw new Exception("create presenter instance fail!", e16);
            }
        }
        throw new Exception("Presenter ClassName is empty");
    }

    public void a(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.mAppId = appId;
    }

    public void a(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mRootView = rootView;
        View view = null;
        if (rootView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            rootView = null;
        }
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f904452h);
        recyclerView.setAdapter(this.mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view2;
        }
        View findViewById = view.findViewById(R.id.f904552i);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mm.ui.widget.MMSwitchBtn");
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById;
        this.mSwitchBtn = mMSwitchBtn;
        if (mMSwitchBtn != null) {
            mMSwitchBtn.setSwitchListener(new d());
        }
    }

    public final void a(com.tencent.luggage.wxa.g5.c result) {
        w.d("Luggage.STANDALONE.WxaSubscribeMsgLogicImpl", "alvinluo updateResult %d, isOpened: %b", Integer.valueOf(result.c().size()), Boolean.valueOf(result.e()));
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f904452h);
        if (recyclerView != null) {
            recyclerView.setVisibility(true ^ result.c().isEmpty() ? 0 : 8);
        }
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.f905052n);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        a(result.e(), result.c(), result.a());
    }

    public final void a(boolean r26, List items, String exampleTitle) {
        MMSwitchBtn mMSwitchBtn = this.mSwitchBtn;
        if (mMSwitchBtn != null) {
            mMSwitchBtn.setCheck(r26);
        }
        this.mDataList.clear();
        this.mDataList.addAll(items);
        com.tencent.luggage.wxa.f5.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.a(this.mDataList);
        }
        com.tencent.luggage.wxa.f5.a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.a(exampleTitle);
        }
        a(r26);
    }

    public final void a(boolean show) {
        Resources resources;
        int i3;
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ((RecyclerView) view.findViewById(R.id.f904452h)).setVisibility(((this.mDataList.isEmpty() ^ true) && show) ? 0 : 8);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        TextView textView = (TextView) view2.findViewById(R.id.f904752k);
        if (!this.mDataList.isEmpty()) {
            Context context = this.mContainerAction.getContext();
            textView.setVisibility(0);
            String string = context.getString(show ? R.string.zf7 : R.string.f170603zf4);
            Intrinsics.checkNotNullExpressionValue(string, "if (show) context.getStr\u2026_msg_close_with_nickname)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(string, Arrays.copyOf(new Object[]{this.mNickname}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            int paddingLeft = textView.getPaddingLeft();
            if (show) {
                resources = context.getResources();
                i3 = R.dimen.bkm;
            } else {
                resources = context.getResources();
                i3 = R.dimen.bp8;
            }
            textView.setPadding(paddingLeft, resources.getDimensionPixelSize(i3), textView.getPaddingRight(), textView.getPaddingBottom());
        } else {
            textView.setVisibility(8);
        }
        com.tencent.luggage.wxa.f5.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final void a() {
        com.tencent.luggage.wxa.h5.a aVar = this.presenter;
        if (aVar != null) {
            aVar.a(new b());
        }
    }
}
