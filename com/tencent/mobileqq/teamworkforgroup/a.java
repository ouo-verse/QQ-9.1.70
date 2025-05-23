package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rely.a;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a extends com.tencent.mobileqq.teamworkforgroup.b {

    /* renamed from: i, reason: collision with root package name */
    public static i f292562i = new i(0, R.id.azx, R.string.a46, R.drawable.cj_);

    /* renamed from: j, reason: collision with root package name */
    public static i f292563j = new i(0, R.id.azw, R.string.f170754a45, R.drawable.cja);

    /* renamed from: k, reason: collision with root package name */
    public static i f292564k = new i(0, R.id.azy, R.string.a47, R.drawable.cjb);

    /* renamed from: l, reason: collision with root package name */
    private static int[] f292565l = {BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.atw), BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.atx)};

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.rely.b f292566e;

    /* renamed from: f, reason: collision with root package name */
    protected int f292567f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnClickListener f292568g;

    /* renamed from: h, reason: collision with root package name */
    private d f292569h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamworkforgroup.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class ViewOnClickListenerC8643a implements View.OnClickListener {
        ViewOnClickListenerC8643a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (Utils.p(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM, view.getTag())) {
                h hVar = (h) view.getTag(-10);
                if (view.getId() == R.id.azx) {
                    a.this.i(hVar);
                } else if (a.this.f292569h != null) {
                    a.this.f292569h.a(view.getId(), hVar);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends com.tencent.mobileqq.rely.b {

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ List f292571j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int[] f292572k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4, List list, int[] iArr5) {
            super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
            this.f292571j = list;
            this.f292572k = iArr5;
        }

        @Override // com.tencent.mobileqq.rely.a
        public void c(int i3, Object obj, a.b[] bVarArr) {
            List<i> g16 = a.this.g((h) obj);
            int size = g16.size();
            if (size > 3) {
                g16 = g16.subList(size - 2, size);
                g16.add(0, a.f292562i);
            }
            int min = Math.min(g16.size(), 3);
            for (int i16 = 0; i16 < bVarArr.length; i16++) {
                if (i16 < min) {
                    i iVar = g16.get(i16);
                    int indexOf = this.f292571j.indexOf(iVar);
                    if (indexOf < 0) {
                        if (QLog.isColorLevel()) {
                            QLog.i(this.f280849a, 1, "getRightMenuItemInfo error, can not find the menu\uff0c menuId[" + iVar.b() + "]");
                        }
                        a.b bVar = bVarArr[i16];
                        bVar.f280856b = -1;
                        bVar.f280855a = -1;
                    } else {
                        a.b bVar2 = bVarArr[i16];
                        bVar2.f280856b = indexOf;
                        bVar2.f280855a = this.f292572k[indexOf];
                    }
                } else {
                    a.b bVar3 = bVarArr[i16];
                    bVar3.f280856b = -1;
                    bVar3.f280855a = -1;
                }
            }
        }

        @Override // com.tencent.mobileqq.rely.b, com.tencent.mobileqq.rely.a
        public View e(int i3, Object obj, a.b bVar, View.OnClickListener onClickListener) {
            View e16 = super.e(i3, obj, bVar, onClickListener);
            if (e16 != null) {
                e16.setTag(-10, obj);
            }
            return e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f292574d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f292575e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f292576f;

        c(List list, h hVar, ActionSheet actionSheet) {
            this.f292574d = list;
            this.f292575e = hVar;
            this.f292576f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 < this.f292574d.size()) {
                i iVar = (i) this.f292574d.get(i3);
                if (a.this.f292569h != null) {
                    a.this.f292569h.a(iVar.b(), this.f292575e);
                }
                this.f292576f.dismiss();
                return;
            }
            this.f292576f.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a(int i3, h hVar);
    }

    public a(AppInterface appInterface, Context context, BaseAdapter baseAdapter, int i3) {
        super(appInterface, context, baseAdapter, i3);
        this.f292567f = 0;
        this.f292568g = new ViewOnClickListenerC8643a();
    }

    private com.tencent.mobileqq.rely.b e() {
        com.tencent.mobileqq.rely.b bVar = this.f292566e;
        if (bVar != null) {
            return bVar;
        }
        ArrayList arrayList = new ArrayList(f());
        if (arrayList.size() > 3) {
            arrayList.add(0, f292562i);
        }
        int[] iArr = new int[arrayList.size()];
        int[] iArr2 = new int[arrayList.size()];
        int[] iArr3 = new int[arrayList.size()];
        int[] iArr4 = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            i iVar = (i) arrayList.get(i3);
            iArr[i3] = iVar.b();
            iArr2[i3] = iVar.c();
            iArr3[i3] = iVar.a();
            iArr4[i3] = iVar.d();
        }
        b bVar2 = new b(arrayList.size(), 2, f292565l, -1, iArr, iArr2, iArr3, arrayList, iArr4);
        this.f292566e = bVar2;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(h hVar) {
        ActionSheet actionSheet = (ActionSheet) ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).actionSheetHelperCreateDialog(this.f292579b, null);
        List<i> subList = g(hVar).subList(0, r1.size() - 2);
        Iterator<i> it = subList.iterator();
        while (it.hasNext()) {
            actionSheet.addButton(this.f292579b.getResources().getString(it.next().c()), 1);
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new c(subList, hVar, actionSheet));
        actionSheet.show();
    }

    @Override // com.tencent.mobileqq.teamworkforgroup.b
    public final View a(int i3, h hVar, View view, ViewGroup viewGroup, boolean z16, boolean z17, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, boolean z18, int i16) {
        a.C8502a c8502a;
        View view2;
        com.tencent.mobileqq.rely.b e16 = e();
        if (view == null) {
            c8502a = new a.C8502a();
            view2 = e16.b(this.f292579b, d(i3, hVar, c8502a.f280853a, viewGroup, z16, z17, onClickListener, onLongClickListener, z18, i16), c8502a, -1);
            view2.setTag(c8502a);
        } else {
            c8502a = (a.C8502a) view.getTag();
            d(i3, hVar, c8502a.f280853a, viewGroup, z16, z17, onClickListener, onLongClickListener, z18, i16);
            view2 = view;
        }
        e16.f(this.f292579b, view2, i3, hVar, c8502a, this.f292568g);
        view2.setEnabled(false);
        return view2;
    }

    public abstract View d(int i3, h hVar, View view, ViewGroup viewGroup, boolean z16, boolean z17, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, boolean z18, int i16);

    public abstract List<i> f();

    public abstract List<i> g(h hVar);

    public void h(d dVar) {
        this.f292569h = dVar;
    }
}
