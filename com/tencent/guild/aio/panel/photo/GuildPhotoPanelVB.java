package com.tencent.guild.aio.panel.photo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelUIState;
import com.tencent.guild.aio.panel.photo.c;
import com.tencent.guild.aio.panel.photo.widget.ItemSwipeSendDecoration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vn0.z;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u0014\u0010\u001a\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0018J\u0006\u0010\u001b\u001a\u00020\u0002R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVB;", "", "", "a", "Landroid/content/Context;", "context", "Landroid/view/View;", "c", "g", "b", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelUIState;", "uiState", "e", "j", "i", "k", "l", "", com.tencent.luggage.wxa.c8.c.E, "", "d", "Lol3/b;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/Observer;", "observer", "f", tl.h.F, "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "Lvn0/z;", "Lvn0/z;", "viewBinding", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVM;", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVM;", "viewModel", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelAdapter;", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelAdapter;", "guildPhotoPanelAdapter", "<init>", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPhotoPanelVB {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.part.root.panel.mvx.config.c panelParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private z viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private GuildPhotoPanelVM viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildPhotoPanelAdapter guildPhotoPanelAdapter;

    public GuildPhotoPanelVB(@NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        this.panelParam = panelParam;
    }

    private final void a() {
        z zVar = this.viewBinding;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            zVar = null;
        }
        final QUIButton sendBtn = zVar.f442068h;
        Intrinsics.checkNotNullExpressionValue(sendBtn, "sendBtn");
        final long j3 = 500;
        sendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVB$bindViewAndData$lambda$5$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                sendBtn.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.m(c.h.f112087d);
                final View view = sendBtn;
                view.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVB$bindViewAndData$lambda$5$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        final QUICheckBox qualityCheckbox = zVar.f442065e;
        Intrinsics.checkNotNullExpressionValue(qualityCheckbox, "qualityCheckbox");
        qualityCheckbox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVB$bindViewAndData$lambda$5$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                qualityCheckbox.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.m(new c.e(((CheckBox) it).isChecked()));
                this.k();
                final View view = qualityCheckbox;
                view.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVB$bindViewAndData$lambda$5$$inlined$setSingleClickListener$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        final TextView albumBtn = zVar.f442062b;
        Intrinsics.checkNotNullExpressionValue(albumBtn, "albumBtn");
        albumBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVB$bindViewAndData$lambda$5$$inlined$setSingleClickListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                albumBtn.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.m(c.C1208c.f112082d);
                final View view = albumBtn;
                view.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVB$bindViewAndData$lambda$5$$inlined$setSingleClickListener$3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        i();
        f(new Observer() { // from class: com.tencent.guild.aio.panel.photo.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildPhotoPanelVB.this.e((GuildPhotoPanelUIState) obj);
            }
        });
    }

    public final void b() {
        this.viewModel = new GuildPhotoPanelVM(this.panelParam);
    }

    @NotNull
    public final View c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b();
        g(context);
        a();
        z zVar = this.viewBinding;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            zVar = null;
        }
        InterceptParentTouchLayout root = zVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        return root;
    }

    @NotNull
    public final String d(long len) {
        String str;
        double d16 = len / 1024000;
        if (d16 >= 10.0d) {
            str = new DecimalFormat("0").format(d16) + "M";
        } else if (d16 >= 1.0d) {
            str = new DecimalFormat("0.0").format(d16) + "M";
        } else if (d16 >= 0.001d) {
            str = new DecimalFormat("0").format(d16 * 1024) + "K";
        } else if (d16 >= 1.0E-4d) {
            str = new DecimalFormat("0.0").format(d16 * 1024) + "K";
        } else {
            return "";
        }
        return "(" + str + ")";
    }

    public final void e(@NotNull GuildPhotoPanelUIState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (uiState instanceof GuildPhotoPanelUIState.RefreshUI) {
            z zVar = this.viewBinding;
            if (zVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                zVar = null;
            }
            zVar.f442065e.setChecked(((GuildPhotoPanelUIState.RefreshUI) uiState).getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String());
            j();
            k();
            l();
        }
    }

    public final void f(@NotNull Observer<GuildPhotoPanelUIState> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        GuildPhotoPanelVM guildPhotoPanelVM = this.viewModel;
        if (guildPhotoPanelVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildPhotoPanelVM = null;
        }
        guildPhotoPanelVM.p(observer);
    }

    public final void g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GuildPhotoPanelVM guildPhotoPanelVM = this.viewModel;
        GuildPhotoPanelAdapter guildPhotoPanelAdapter = null;
        if (guildPhotoPanelVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildPhotoPanelVM = null;
        }
        this.guildPhotoPanelAdapter = new GuildPhotoPanelAdapter(guildPhotoPanelVM);
        z g16 = z.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        RecyclerView recyclerView = g16.f442064d;
        GuildPhotoPanelAdapter guildPhotoPanelAdapter2 = this.guildPhotoPanelAdapter;
        if (guildPhotoPanelAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildPhotoPanelAdapter");
            guildPhotoPanelAdapter2 = null;
        }
        recyclerView.setAdapter(guildPhotoPanelAdapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.setItemAnimator(null);
        GuildPhotoPanelAdapter guildPhotoPanelAdapter3 = this.guildPhotoPanelAdapter;
        if (guildPhotoPanelAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildPhotoPanelAdapter");
        } else {
            guildPhotoPanelAdapter = guildPhotoPanelAdapter3;
        }
        new ItemSwipeSendDecoration(new d(guildPhotoPanelAdapter, new GuildPhotoPanelVB$onCreateView$1$1$1(this))).attachToRecyclerView(recyclerView);
        this.viewBinding = g16;
    }

    public final void h() {
        GuildPhotoPanelVM guildPhotoPanelVM = this.viewModel;
        if (guildPhotoPanelVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildPhotoPanelVM = null;
        }
        guildPhotoPanelVM.h();
    }

    public final void i() {
        m(c.f.f112085d);
    }

    public final void j() {
        GuildPhotoPanelAdapter guildPhotoPanelAdapter = this.guildPhotoPanelAdapter;
        if (guildPhotoPanelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildPhotoPanelAdapter");
            guildPhotoPanelAdapter = null;
        }
        guildPhotoPanelAdapter.notifyDataSetChanged();
    }

    public final void k() {
        z zVar = this.viewBinding;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            zVar = null;
        }
        if (zVar.f442065e.isChecked()) {
            z zVar3 = this.viewBinding;
            if (zVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                zVar3 = null;
            }
            TextView textView = zVar3.f442066f;
            GuildPhotoPanelVM guildPhotoPanelVM = this.viewModel;
            if (guildPhotoPanelVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildPhotoPanelVM = null;
            }
            textView.setText(d(guildPhotoPanelVM.f()));
            GuildPhotoPanelVM guildPhotoPanelVM2 = this.viewModel;
            if (guildPhotoPanelVM2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildPhotoPanelVM2 = null;
            }
            if (guildPhotoPanelVM2.s()) {
                com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f1498713g);
            }
            z zVar4 = this.viewBinding;
            if (zVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                zVar2 = zVar4;
            }
            zVar2.f442066f.setVisibility(0);
            return;
        }
        z zVar5 = this.viewBinding;
        if (zVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            zVar2 = zVar5;
        }
        zVar2.f442066f.setVisibility(4);
    }

    public final void l() {
        float f16;
        z zVar = this.viewBinding;
        GuildPhotoPanelVM guildPhotoPanelVM = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            zVar = null;
        }
        QUIButton qUIButton = zVar.f442068h;
        GuildPhotoPanelVM guildPhotoPanelVM2 = this.viewModel;
        if (guildPhotoPanelVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildPhotoPanelVM = guildPhotoPanelVM2;
        }
        if (guildPhotoPanelVM.m().size() > 0) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        qUIButton.setAlpha(f16);
    }

    public final void m(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        GuildPhotoPanelVM guildPhotoPanelVM = this.viewModel;
        if (guildPhotoPanelVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildPhotoPanelVM = null;
        }
        guildPhotoPanelVM.o(intent);
    }
}
