package aw1;

import android.graphics.Bitmap;
import android.view.View;
import aw1.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleViewForProfileCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d extends a<k.b> {

    /* renamed from: c, reason: collision with root package name */
    private GuildLevelRoleViewForProfileCard f27046c;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        k.a aVar = this.f27042b;
        if (aVar != null) {
            aVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(k.b bVar, Bitmap bitmap) {
        if (bitmap == null) {
            QLog.w("GuildLevelRoleGroupTagItemHolder", 1, "bindData fetchLevelImg bitmap is null");
            return null;
        }
        this.f27046c.y(new GuildLevelRoleViewForProfileCard.a(bitmap, bVar.f27069e, bVar.f27070f, bVar.f27067c, bVar.f27072h, bVar.f27073i, bVar.f27075k, bVar.f27076l, bVar.f27074j));
        this.f27046c.setOnClickListener(new View.OnClickListener() { // from class: aw1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.j(view);
            }
        });
        return null;
    }

    @Override // aw1.a
    public void b() {
        this.f27046c = (GuildLevelRoleViewForProfileCard) this.f27041a.findViewById(R.id.wlu);
    }

    @Override // aw1.a
    public int d() {
        return R.id.wui;
    }

    @Override // aw1.a
    protected int e() {
        return R.layout.evt;
    }

    @Override // aw1.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void a(final k.b bVar) {
        GuildLevelRoleViewForProfileCard.u(bVar.f27069e, new Function1() { // from class: aw1.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k3;
                k3 = d.this.k(bVar, (Bitmap) obj);
                return k3;
            }
        });
    }
}
