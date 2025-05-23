package an4;

import an4.b;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import nr2.au;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\n\u00a8\u00062"}, d2 = {"Lan4/c;", "Lcom/tencent/timi/game/ui/widget/a;", "Landroid/view/View$OnClickListener;", "", "initView", "Y", "d0", "", "", "X", "Z", "b0", "a0", "c0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "U", ExifInterface.LATITUDE_SOUTH, "dismiss", "Landroid/app/Activity;", "K", "Landroid/app/Activity;", "dialogActivity", "", "", "L", "Ljava/util/List;", "userList", "M", "Ljava/lang/String;", "teamId", "", "N", "I", VirtualAppProxy.KEY_GAME_ID, "P", "TAG", "Lnr2/au;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lnr2/au;", "binding", "Lan4/b;", BdhLogUtil.LogTag.Tag_Req, "Lan4/b;", "adapter", "", "dismissed", "<init>", "(Landroid/app/Activity;Ljava/util/List;Ljava/lang/String;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c extends com.tencent.timi.game.ui.widget.a implements View.OnClickListener {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Activity dialogActivity;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final List<Long> userList;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final String teamId;

    /* renamed from: N, reason: from kotlin metadata */
    private final int gameId;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private au binding;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private b adapter;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean dismissed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Activity dialogActivity, @NotNull List<Long> userList, @NotNull String teamId, int i3) {
        super(dialogActivity);
        Intrinsics.checkNotNullParameter(dialogActivity, "dialogActivity");
        Intrinsics.checkNotNullParameter(userList, "userList");
        Intrinsics.checkNotNullParameter(teamId, "teamId");
        this.dialogActivity = dialogActivity;
        this.userList = userList;
        this.teamId = teamId;
        this.gameId = i3;
        this.TAG = "FleetCPDDShareDialog_";
        au g16 = au.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        initView();
    }

    private final Map<String, String> X() {
        Long longOrNull;
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.teamId);
        if (longOrNull != null) {
            gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(longOrNull.longValue());
            if (K0 != null) {
                yoloRoomOuterClass$YoloRoomInfo = K0.getRoomInfo();
            } else {
                yoloRoomOuterClass$YoloRoomInfo = null;
            }
            ConcurrentHashMap<String, String> reportParam = YoloRoomUtil.L(yoloRoomOuterClass$YoloRoomInfo);
            reportParam.put("yes_to_uid", Z());
            reportParam.put("yes_to_yes_uid", ((ll4.a) mm4.b.b(ll4.a.class)).M3());
            reportParam.put("yes_to_uid_cnt", String.valueOf(this.userList.size()));
            Intrinsics.checkNotNullExpressionValue(reportParam, "reportParam");
            return reportParam;
        }
        return new LinkedHashMap();
    }

    private final void Y() {
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        FrameLayout frameLayout = this.binding.f420903f;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.dialogView");
        bVar.G2(frameLayout, "pg_yes_smoba_team");
    }

    private final String Z() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = this.userList.iterator();
        while (it.hasNext()) {
            sb5.append(String.valueOf(((Number) it.next()).longValue()));
            sb5.append(",");
        }
        if (sb5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String substring = sb5.substring(0, sb5.length());
            Intrinsics.checkNotNullExpressionValue(substring, "builder.substring(0, builder.length)");
            return substring;
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }

    private final void a0() {
        if (this.userList.size() == 1) {
            AvatarRoundImageView avatarRoundImageView = this.binding.f420909l;
            if (avatarRoundImageView != null) {
                fh4.g.o(avatarRoundImageView, true);
            }
            AvatarTextView avatarTextView = this.binding.f420910m;
            if (avatarTextView != null) {
                fh4.g.o(avatarTextView, true);
            }
            RecyclerView recyclerView = this.binding.f420912o;
            if (recyclerView != null) {
                fh4.g.o(recyclerView, false);
            }
            CommonOuterClass$QQUserId b26 = ((bo4.d) mm4.b.b(bo4.d.class)).b2(this.userList.get(0).longValue());
            AvatarRoundImageView avatarRoundImageView2 = this.binding.f420909l;
            if (avatarRoundImageView2 != null) {
                avatarRoundImageView2.setUserId(b26);
            }
            AvatarTextView avatarTextView2 = this.binding.f420910m;
            if (avatarTextView2 != null) {
                avatarTextView2.setUserId(b26);
                return;
            }
            return;
        }
        AvatarRoundImageView avatarRoundImageView3 = this.binding.f420909l;
        if (avatarRoundImageView3 != null) {
            fh4.g.o(avatarRoundImageView3, false);
        }
        AvatarTextView avatarTextView3 = this.binding.f420910m;
        if (avatarTextView3 != null) {
            fh4.g.o(avatarTextView3, false);
        }
        RecyclerView recyclerView2 = this.binding.f420912o;
        if (recyclerView2 != null) {
            fh4.g.o(recyclerView2, true);
        }
        c0();
    }

    private final void b0() {
        String str;
        PBStringField pBStringField;
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(this.gameId);
        if (l16 != null && (pBStringField = l16.game_icon) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mRequestWidth = fh4.b.b(32);
        obtain.mRequestHeight = fh4.b.b(32);
        RoundCornerImageView roundCornerImageView = this.binding.f420905h;
        if (roundCornerImageView != null) {
            roundCornerImageView.setRadius(fh4.b.d(4), fh4.b.d(4), fh4.b.d(4), fh4.b.d(4));
        }
        RoundCornerImageView roundCornerImageView2 = this.binding.f420905h;
        if (roundCornerImageView2 != null) {
            roundCornerImageView2.setImageDrawable(((ei4.a) mm4.b.b(ei4.a.class)).m(str, obtain));
        }
    }

    private final void c0() {
        this.binding.f420912o.setLayoutManager(new LinearLayoutManager(this.G, 0, false));
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.userList.iterator();
        while (it.hasNext()) {
            arrayList.add(((bo4.d) mm4.b.b(bo4.d.class)).b2(((Number) it.next()).longValue()));
        }
        Context context = this.G;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        b bVar = new b(context, arrayList);
        this.adapter = bVar;
        this.binding.f420912o.setAdapter(bVar);
        RecyclerView recyclerView = this.binding.f420912o;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new b.a(this.userList.size()));
        }
    }

    private final void d0() {
        ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
        MediumBoldTextView mediumBoldTextView = this.binding.f420900c;
        Intrinsics.checkNotNullExpressionValue(mediumBoldTextView, "binding.cancelButton");
        bVar.a(mediumBoldTextView, true, null, "em_yes_share_win_close", X());
        ug4.b bVar2 = (ug4.b) mm4.b.b(ug4.b.class);
        MediumBoldTextView mediumBoldTextView2 = this.binding.f420906i;
        Intrinsics.checkNotNullExpressionValue(mediumBoldTextView2, "binding.sendButton");
        bVar2.a(mediumBoldTextView2, true, null, "em_yes_share_win_confirm", X());
    }

    private final void initView() {
        setContentView(this.binding.getRoot());
        a0();
        Y();
        ScrollView scrollView = this.binding.f420902e;
        if (scrollView != null) {
            fh4.g.f(scrollView, fh4.b.b(6), -1);
        }
        MediumBoldTextView mediumBoldTextView = this.binding.f420900c;
        if (mediumBoldTextView != null) {
            mediumBoldTextView.setOnClickListener(this);
        }
        MediumBoldTextView mediumBoldTextView2 = this.binding.f420906i;
        if (mediumBoldTextView2 != null) {
            mediumBoldTextView2.setOnClickListener(this);
        }
        View view = this.binding.f420899b;
        if (view != null) {
            view.setOnClickListener(this);
        }
        b0();
        d0();
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    /* renamed from: S */
    public View getBgView() {
        View view = this.binding.f420899b;
        Intrinsics.checkNotNullExpressionValue(view, "binding.bgView");
        return view;
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    public View U() {
        ScrollView scrollView = this.binding.f420902e;
        Intrinsics.checkNotNullExpressionValue(scrollView, "binding.contentView");
        return scrollView;
    }

    @Override // com.tencent.timi.game.ui.widget.a, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.dismissed = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.a()) {
            int id5 = v3.getId();
            boolean z16 = true;
            if (id5 != R.id.t67 && id5 != R.id.tlc) {
                z16 = false;
            }
            if (z16) {
                dismiss();
            } else if (id5 == R.id.f166846in1) {
                a.f26353a.j(this.dialogActivity, this.userList, this.teamId);
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
