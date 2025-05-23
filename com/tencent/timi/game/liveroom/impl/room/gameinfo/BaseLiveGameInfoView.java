package com.tencent.timi.game.liveroom.impl.room.gameinfo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.gameinfo.BaseLiveGameInfoView;
import com.tencent.timi.game.utils.b;
import com.tencent.timi.game.utils.d;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import fh4.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lo4.a;
import nr2.ae;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.PremadesTeamServerOuterClass$AnchorGameInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001 B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0014J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0004J\u0006\u0010\u0010\u001a\u00020\tJ\b\u0010\u0012\u001a\u00020\u0011H&R\u001a\u0010\u0017\u001a\u00020\u00138\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/BaseLiveGameInfoView;", "Landroid/widget/RelativeLayout;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;", "info", "", "i", h.F, "Landroid/view/View;", "view", "", "url", "f", "", "showTag", "j", "g", "d", "Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "e", "Lnr2/ae;", "Lnr2/ae;", "c", "()Lnr2/ae;", "binding", "Ljava/lang/String;", "inscriptionUrl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class BaseLiveGameInfoView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ae binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String inscriptionUrl;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseLiveGameInfoView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BaseLiveGameInfoView this$0, View view) {
        Activity d16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.a() && (d16 = b.d(this$0)) != null) {
            if (TextUtils.isEmpty(this$0.getInscriptionUrl())) {
                QLog.w("LIVE_BANNER", 1, "initView:\u6570\u636e\u51fa\u9519 inscriptionUrl is empty!!");
            } else {
                l.e("LIVE_BANNER", "setOnClickListener " + this$0.getInscriptionUrl());
                ((a) mm4.b.b(a.class)).X(d16, this$0.getInscriptionUrl(), this$0.e());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f(View view, String url) {
        ImageView imageView = (ImageView) view.findViewById(R.id.x_3);
        d dVar = d.f380295a;
        dVar.d(url, imageView, dVar.c(ViewUtils.dpToPx(22.0f), imageView, 0));
    }

    private final void h(PremadesTeamServerOuterClass$AnchorGameInfo info) {
        this.binding.f420796h.removeAllViews();
        if (info != null) {
            if (!getInscriptionUrl().equals(info.url.get())) {
                a aVar = (a) mm4.b.b(a.class);
                String str = info.url.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.url.get()");
                aVar.Z1(str);
            }
            String str2 = info.url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "it.url.get()");
            this.inscriptionUrl = str2;
            int b16 = fh4.b.b(2);
            int b17 = fh4.b.b(20);
            List<String> list = info.equip_url_list.get();
            Intrinsics.checkNotNullExpressionValue(list, "it.equip_url_list.get()");
            for (String url : list) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.hsz, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                Intrinsics.checkNotNullExpressionValue(url, "url");
                f(view, url);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b17, b17);
                layoutParams.leftMargin = b16;
                layoutParams.rightMargin = b16;
                this.binding.f420796h.addView(view, layoutParams);
            }
        }
    }

    private final void i(PremadesTeamServerOuterClass$AnchorGameInfo info) {
        this.binding.f420796h.removeAllViews();
        if (info != null) {
            if (!getInscriptionUrl().equals(info.url.get())) {
                a aVar = (a) mm4.b.b(a.class);
                String str = info.url.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.url.get()");
                aVar.Z1(str);
            }
            String str2 = info.url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "it.url.get()");
            this.inscriptionUrl = str2;
            int b16 = fh4.b.b(2);
            int b17 = fh4.b.b(22);
            List<String> list = info.hero_url_list.get();
            Intrinsics.checkNotNullExpressionValue(list, "it.hero_url_list.get()");
            for (String url : list) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.hsy, (ViewGroup) null);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                Intrinsics.checkNotNullExpressionValue(url, "url");
                f(view, url);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b17, b17);
                layoutParams.leftMargin = b16;
                layoutParams.rightMargin = b16;
                this.binding.f420796h.addView(view, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: c, reason: from getter */
    public final ae getBinding() {
        return this.binding;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getInscriptionUrl() {
        return this.inscriptionUrl;
    }

    @NotNull
    public abstract LivingRoomInfo e();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(@Nullable PremadesTeamServerOuterClass$AnchorGameInfo info, boolean showTag) {
        List<String> list;
        PBInt32Field pBInt32Field;
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBRepeatField<String> pBRepeatField;
        LiveGameInfoTextView liveGameInfoTextView = this.binding.f420792d;
        String str2 = null;
        if (info != null && (pBRepeatField = info.new_title) != null) {
            list = pBRepeatField.get();
        } else {
            list = null;
        }
        liveGameInfoTextView.setData(list);
        if (info != null && (pBStringField2 = info.fans_data) != null) {
            str2 = pBStringField2.get();
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(str2)) {
            this.binding.f420793e.setVisibility(8);
        } else {
            this.binding.f420793e.setVisibility(0);
            this.binding.f420793e.setText(str2);
        }
        TextView textView = this.binding.f420791c;
        if (textView != null) {
            if (info == null || (pBStringField = info.desc) == null || (str = pBStringField.get()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        if (info != null && (pBInt32Field = info.is_playing) != null && pBInt32Field.get() == 1) {
            z16 = true;
        }
        if (!z16) {
            i(info);
        } else {
            h(info);
        }
        j(info, showTag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@Nullable PremadesTeamServerOuterClass$AnchorGameInfo info, boolean showTag) {
        String str;
        boolean z16;
        PBStringField pBStringField;
        if (info != null && (pBStringField = info.url) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (showTag && !TextUtils.isEmpty(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        g.o(this, z16);
    }

    public /* synthetic */ BaseLiveGameInfoView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseLiveGameInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ae f16 = ae.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.inscriptionUrl = "";
        setOnClickListener(new View.OnClickListener() { // from class: nj4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseLiveGameInfoView.b(BaseLiveGameInfoView.this, view);
            }
        });
        setBackgroundColor(Color.parseColor("#313138"));
        ImageView imageView = f16.f420794f;
        if (imageView != null) {
            imageView.setColorFilter(Color.parseColor("#84818E"));
        }
    }
}
