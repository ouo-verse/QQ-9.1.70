package ow;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.aj;
import com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager;
import com.tencent.av.zplan.avatar.manager.AVChatBgSwitchLoadingManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends nw.a {
    private ImageView C;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f424206e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Context> f424207f;

    /* renamed from: h, reason: collision with root package name */
    private View f424208h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f424209i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f424210m;

    public a(Context context, AppInterface appInterface) {
        z9(context, appInterface);
        C9(x9(this.f424207f));
    }

    private void A9() {
        WeakReference<Context> weakReference;
        if (this.f424206e == null || (weakReference = this.f424207f) == null) {
            return;
        }
        AVActivity x95 = x9(weakReference);
        r.h0().G().l(this.f424208h, this.f424209i, this.f424210m);
        r.h0().B().f(this.C);
        aj.a(x95);
    }

    private void B9() {
        if (this.f424206e == null) {
            return;
        }
        AVChatAvatarEasterEggManager G = r.h0().G();
        G.w();
        G.m();
        AVChatBgSwitchLoadingManager B = r.h0().B();
        B.k();
        B.g();
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f424208h = view.findViewById(R.id.f29940n0);
        this.f424209i = (ImageView) view.findViewById(R.id.f29920my);
        this.f424210m = (ImageView) view.findViewById(R.id.f29930mz);
        this.C = (ImageView) view.findViewById(R.id.f29910mx);
        A9();
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.f424206e = new WeakReference<>((VideoAppInterface) appInterface);
        this.f424207f = new WeakReference<>(context);
    }

    public void C9(Activity activity) {
        super.onInitView(null);
        this.f424208h = activity.findViewById(R.id.f29940n0);
        this.f424209i = (ImageView) activity.findViewById(R.id.f29920my);
        this.f424210m = (ImageView) activity.findViewById(R.id.f29930mz);
        this.C = (ImageView) activity.findViewById(R.id.f29910mx);
        A9();
    }

    @Override // nw.a
    public void onDestroy() {
        this.f424208h = null;
        this.f424209i = null;
        this.f424210m = null;
        this.C = null;
        B9();
        this.f424206e = null;
        this.f424207f = null;
    }
}
