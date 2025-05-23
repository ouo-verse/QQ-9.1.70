package cooperation.qqfav.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.dw;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements View.OnClickListener {
    int C;
    AppRuntime D;

    /* renamed from: d, reason: collision with root package name */
    ShareActionSheet f390708d;

    /* renamed from: f, reason: collision with root package name */
    int f390710f;

    /* renamed from: h, reason: collision with root package name */
    b f390711h;

    /* renamed from: e, reason: collision with root package name */
    boolean f390709e = false;

    /* renamed from: i, reason: collision with root package name */
    List<Integer> f390712i = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    List<String> f390713m = new ArrayList();

    /* compiled from: P */
    /* renamed from: cooperation.qqfav.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    class C10116a implements ShareActionSheet.OnItemClickListener {
        C10116a() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            if (shareActionSheet != null) {
                shareActionSheet.dismiss();
            }
            a.this.d(actionSheetItem.action, actionSheetItem);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d(Bundle bundle);

        void e();

        void f();

        Intent g();

        void h();

        void i();

        void j();

        void k();

        void l();

        int m();

        void n();

        void o();

        void onShow();

        void s();
    }

    public a(Activity activity, b bVar, int i3, int i16, AppRuntime appRuntime) {
        this.f390708d = null;
        this.f390710f = 1;
        this.f390711h = null;
        this.f390710f = i3;
        this.f390711h = bVar;
        this.C = i16;
        this.D = appRuntime;
        if (this.f390708d == null) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = activity;
            ShareActionSheet create = ShareActionSheetFactory.create(param);
            this.f390708d = create;
            create.setActionSheetTitle(activity.getString(R.string.bgc));
            this.f390708d.setItemClickListenerV2(new C10116a());
        }
        b();
    }

    private void b() {
        b bVar = this.f390711h;
        if (bVar != null) {
            c(bVar.m());
        }
    }

    private void c(int i3) {
        Intent intent;
        int i16;
        int i17;
        this.f390710f = i3;
        b bVar = this.f390711h;
        if (bVar != null) {
            intent = bVar.g();
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("big_brother_source_key", "biz_src_qfav");
            intent.putExtra("big_brother_source_key", "biz_src_jc_shoucang");
            this.f390708d.setIntentForStartForwardRecentActivity(intent);
        } else {
            intent = null;
        }
        if ((this.f390710f & 65536) != 0) {
            this.f390708d.setRowVisibility(8, 8, 0);
        } else {
            ShareActionSheet shareActionSheet = this.f390708d;
            if (intent != null) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            if (intent != null) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            shareActionSheet.setRowVisibility(i16, i17, 0);
        }
        ArrayList arrayList = new ArrayList();
        dw.a(2, arrayList);
        if ((this.f390710f & 512) != 0) {
            dw.a(26, arrayList);
        }
        if ((this.f390710f & 16384) != 0) {
            dw.a(64, arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        if ((this.f390710f & 128) != 0) {
            dw.a(70, arrayList2);
        }
        if ((this.f390710f & 256) != 0) {
            dw.a(82, arrayList2);
        }
        if ((8 & this.f390710f) != 0) {
            dw.a(39, arrayList2);
        }
        if ((this.f390710f & 1024) != 0) {
            dw.a(130, arrayList2);
        }
        if ((this.f390710f & 32768) != 0) {
            dw.a(131, arrayList2);
        }
        if ((this.f390710f & 16) != 0) {
            dw.a(94, arrayList2);
        }
        if ((64 & this.f390710f) != 0) {
            dw.a(129, arrayList2);
        }
        if ((this.f390710f & 2048) != 0) {
            dw.a(52, arrayList2);
        }
        if ((this.f390710f & 8192) != 0) {
            dw.a(55, arrayList2);
        }
        if ((this.f390710f & 4096) != 0) {
            dw.a(56, arrayList2);
        }
        this.f390708d.setActionSheetItems(arrayList, arrayList2);
    }

    public void a() {
        ShareActionSheet shareActionSheet = this.f390708d;
        if (shareActionSheet != null) {
            if (shareActionSheet.isShowing()) {
                this.f390708d.dismiss();
                if (QLog.isDevelopLevel()) {
                    QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|showing");
                }
            } else if (QLog.isDevelopLevel()) {
                QLog.d("qqfav.FavoriteActionSheet", 4, "dismiss|not showing");
            }
            this.f390708d = null;
        }
    }

    protected void d(int i3, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (i3 != 2) {
            if (i3 != 26) {
                if (i3 != 39) {
                    if (i3 != 52) {
                        if (i3 != 64) {
                            if (i3 != 70) {
                                if (i3 != 82) {
                                    if (i3 != 94) {
                                        if (i3 != 55) {
                                            if (i3 != 56) {
                                                if (i3 != 72) {
                                                    if (i3 != 73) {
                                                        switch (i3) {
                                                            case 129:
                                                                this.f390711h.o();
                                                                return;
                                                            case 130:
                                                                this.f390711h.l();
                                                                return;
                                                            case 131:
                                                                this.f390711h.i();
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                    }
                                                } else {
                                                    Bundle bundle = new Bundle();
                                                    bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                                                    bundle.putInt("key_direct_show_uin_type", actionSheetItem.uinType);
                                                    bundle.putString("key_direct_show_uin", actionSheetItem.uin);
                                                    this.f390711h.d(bundle);
                                                    return;
                                                }
                                            } else {
                                                this.f390711h.f();
                                                return;
                                            }
                                        } else {
                                            this.f390711h.k();
                                            return;
                                        }
                                    } else {
                                        this.f390711h.h();
                                        return;
                                    }
                                } else {
                                    this.f390711h.j();
                                    return;
                                }
                            } else {
                                this.f390711h.s();
                                return;
                            }
                        } else {
                            this.f390711h.c();
                            return;
                        }
                    } else {
                        this.f390711h.b();
                        return;
                    }
                } else {
                    this.f390711h.a();
                    return;
                }
            } else {
                this.f390711h.n();
                return;
            }
        }
        this.f390711h.e();
    }

    public void e(int i3) {
        if (this.f390708d != null) {
            c(i3);
            this.f390708d.refresh();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ShareActionSheet shareActionSheet = this.f390708d;
        if (shareActionSheet != null && !shareActionSheet.isShowing()) {
            this.f390709e = false;
            b();
            this.f390708d.refresh();
            this.f390708d.show();
            this.f390711h.onShow();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c implements b {
        @Override // cooperation.qqfav.widget.a.b
        public Intent g() {
            Intent intent = new Intent();
            intent.putExtra("forward_type", 22);
            intent.putExtra("pluginName", "struct_favorite");
            return intent;
        }

        @Override // cooperation.qqfav.widget.a.b
        public int m() {
            return 0;
        }

        @Override // cooperation.qqfav.widget.a.b
        public void a() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void b() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void c() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void e() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void f() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void h() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void i() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void j() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void k() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void l() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void n() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void o() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void onShow() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void s() {
        }

        @Override // cooperation.qqfav.widget.a.b
        public void d(Bundle bundle) {
        }
    }
}
