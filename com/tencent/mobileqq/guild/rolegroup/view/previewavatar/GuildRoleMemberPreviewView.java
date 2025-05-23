package com.tencent.mobileqq.guild.rolegroup.view.previewavatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.view.previewavatar.GuildRoleMemberPreviewView;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes14.dex */
public class GuildRoleMemberPreviewView extends LinearLayout {
    private a C;

    @Nullable
    private a.InterfaceC7880a D;

    /* renamed from: d, reason: collision with root package name */
    private int f232839d;

    /* renamed from: e, reason: collision with root package name */
    private int f232840e;

    /* renamed from: f, reason: collision with root package name */
    private Context f232841f;

    /* renamed from: h, reason: collision with root package name */
    private View f232842h;

    /* renamed from: i, reason: collision with root package name */
    private IGPSService f232843i;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f232844m;

    public GuildRoleMemberPreviewView(Context context) {
        super(context);
        this.f232839d = 5;
        this.f232840e = 3;
        this.f232841f = context;
        h();
        g();
    }

    private List<a.b> b(List<a.b> list, boolean z16, boolean z17) {
        int i3;
        int e16 = e();
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        if (z17) {
            arrayList.add(new a.b(0, "", "", "\u6dfb\u52a0"));
        }
        while (true) {
            i3 = (e16 - 1) - (z17 ? 1 : 0);
            if (i16 >= Math.min(i3, list.size())) {
                break;
            }
            arrayList.add(list.get(i16));
            i16++;
        }
        if (list.size() < i3) {
            return arrayList;
        }
        if (list.size() == i3 && !z16) {
            return arrayList;
        }
        if (list.size() == e16 - (z17 ? 1 : 0) && !z16) {
            arrayList.add(list.get(i3));
        } else {
            arrayList.add(new a.b(1, "", "", "\u66f4\u591a"));
        }
        return arrayList;
    }

    private static void d(@NonNull View view, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams.height != i3) {
            layoutParams.height = i3;
            view.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, a.b bVar) {
        a.InterfaceC7880a interfaceC7880a = this.D;
        if (interfaceC7880a == null) {
            if (QLog.isColorLevel()) {
                QLog.w("Guild.rg.GuildRoleMemberPreviewView", 2, "previewItemClicked but do not bindCallback");
                return;
            }
            return;
        }
        interfaceC7880a.a(view, bVar);
    }

    private void g() {
        this.f232843i = (IGPSService) ch.R0(IGPSService.class);
        a aVar = new a(new a.InterfaceC7880a() { // from class: gy1.a
            @Override // com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a.InterfaceC7880a
            public final void a(View view, a.b bVar) {
                GuildRoleMemberPreviewView.this.f(view, bVar);
            }
        });
        this.C = aVar;
        this.f232844m.setAdapter(aVar);
    }

    private void h() {
        View inflate = LayoutInflater.from(this.f232841f).inflate(R.layout.ess, this);
        this.f232842h = inflate;
        this.f232844m = (RecyclerView) inflate.findViewById(R.id.f27320fx);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f232841f, this.f232839d);
        gridLayoutManager.offsetChildrenVertical(0);
        gridLayoutManager.offsetChildrenHorizontal(0);
        this.f232844m.setLayoutManager(gridLayoutManager);
    }

    private void i(List<a.b> list) {
        d(this.f232842h, ViewUtils.dpToPx(Math.max((((int) Math.ceil(list.size() / this.f232839d)) * 81) + 25, 104)));
        this.C.i0(list);
    }

    public void c(a.InterfaceC7880a interfaceC7880a) {
        this.D = interfaceC7880a;
    }

    public int e() {
        return this.f232839d * this.f232840e;
    }

    public void setPreviewItemDataWithNickname(List<a.b> list, boolean z16) {
        i(b(list, z16, true));
    }

    public void setPreviewItemDataWithNicknameDirectly(List<a.b> list) {
        i(list);
    }

    public void setTargetArrange(int i3, int i16) {
        this.f232840e = i3;
        this.f232839d = i16;
        this.f232844m.setLayoutManager(new GridLayoutManager(this.f232841f, i16));
        this.f232844m.requestLayout();
    }

    public void setPreviewItemDataWithNickname(List<a.b> list, boolean z16, boolean z17) {
        i(b(list, z16, z17));
    }

    public GuildRoleMemberPreviewView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f232839d = 5;
        this.f232840e = 3;
        this.f232841f = context;
        h();
        g();
    }

    public GuildRoleMemberPreviewView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f232839d = 5;
        this.f232840e = 3;
        this.f232841f = context;
        h();
        g();
    }
}
