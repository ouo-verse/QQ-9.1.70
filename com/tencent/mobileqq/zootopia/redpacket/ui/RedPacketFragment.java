package com.tencent.mobileqq.zootopia.redpacket.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.falco.utils.UIUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IRedPacketApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\u0002J&\u0010/\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\bJ\b\u00100\u001a\u00020\u0002H\u0016R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "", "initView", "", "color", "Bh", "wh", "", "needKeepLoading", "vh", "url", "Ch", "text", OcrConfig.CHINESE, "Ih", "Dh", "Hh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/b;", "rh", "Landroid/view/View$OnClickListener;", "listener", "Gh", "Lhd3/b;", "data", "Eh", "Fh", "path", "Jh", "yh", "", "avartarId", "", "redPacketId", "title", "result", "xh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewModel;", "viewModel", "D", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/b;", "adapter", "Lfi3/b;", "E", "Lfi3/b;", "sh", "()Lfi3/b;", "setBinding", "(Lfi3/b;)V", "binding", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/e;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zootopia/redpacket/ui/e;", "sendingDialog", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewBinder;", "G", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewBinder;", "viewBinder", "H", "Z", "isNeedReloadAvatar", "Lid3/d;", "I", "Lid3/d;", "reporter", "<init>", "()V", "J", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RedPacketFragment extends QBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final b adapter;

    /* renamed from: E, reason: from kotlin metadata */
    private fi3.b binding;

    /* renamed from: F, reason: from kotlin metadata */
    private e sendingDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private RedPacketViewBinder viewBinder;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isNeedReloadAvatar;

    /* renamed from: I, reason: from kotlin metadata */
    private final id3.d reporter;

    public RedPacketFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RedPacketViewModel>() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.RedPacketFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RedPacketViewModel invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(RedPacketFragment.this.getQBaseActivity()).get(RedPacketViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(qBas\u2026ketViewModel::class.java)");
                return (RedPacketViewModel) viewModel;
            }
        });
        this.viewModel = lazy;
        this.adapter = new b();
        this.viewBinder = new RedPacketViewBinder();
        this.reporter = new id3.d(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(RedPacketFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isNeedReloadAvatar = true;
        QRouteApi api = QRoute.api(IZootopiaApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaApi::class.java)");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        IZootopiaApi.a.c((IZootopiaApi) api, context, ZootopiaSource.INSTANCE.a(Source.RedPacket), null, 4, null);
    }

    private final void Ch(String url) {
        ImageView imageView;
        fi3.b bVar = this.binding;
        if (bVar == null || (imageView = bVar.f399013i) == null) {
            return;
        }
        com.tencent.mobileqq.zootopia.redpacket.j.f329071a.e(imageView, url, Integer.valueOf(ViewUtils.getScreenWidth()), Integer.valueOf((int) (ViewUtils.getScreenWidth() * 0.90933335f)));
    }

    private final void Dh(String color) {
        RoundCorneredRelativeLayout roundCorneredRelativeLayout;
        fi3.b bVar = this.binding;
        if (bVar == null || (roundCorneredRelativeLayout = bVar.f399014j) == null) {
            return;
        }
        com.tencent.mobileqq.zootopia.redpacket.j.f329071a.h(roundCorneredRelativeLayout, color);
    }

    private final void Hh(String url) {
        ImageView imageView;
        fi3.b bVar = this.binding;
        if (bVar == null || (imageView = bVar.f399018n) == null) {
            return;
        }
        com.tencent.mobileqq.zootopia.redpacket.j.f329071a.e(imageView, url, Integer.valueOf(UIUtil.dp2px(imageView.getContext(), 198.0f)), Integer.valueOf(UIUtil.dp2px(imageView.getContext(), 45.0f)));
    }

    private final void Ih(String url) {
        ImageView imageView;
        fi3.b bVar = this.binding;
        if (bVar == null || (imageView = bVar.f399019o) == null) {
            return;
        }
        com.tencent.mobileqq.zootopia.redpacket.j.f329071a.e(imageView, url, Integer.valueOf(UIUtil.dp2px(imageView.getContext(), 156.0f)), Integer.valueOf(UIUtil.dp2px(imageView.getContext(), 39.0f)));
    }

    private final void initView() {
        ImageView imageView;
        RoundCorneredRelativeLayout roundCorneredRelativeLayout;
        RecyclerView recyclerView;
        ImageView imageView2;
        fi3.b bVar = this.binding;
        if (bVar != null && (imageView2 = bVar.f399013i) != null) {
            imageView2.getLayoutParams().width = ViewUtils.getScreenWidth();
            imageView2.getLayoutParams().height = (int) (ViewUtils.getScreenWidth() * 0.90933335f);
            imageView2.setLayoutParams(imageView2.getLayoutParams());
        }
        fi3.b bVar2 = this.binding;
        if (bVar2 != null && (recyclerView = bVar2.f399016l) != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
            recyclerView.setAdapter(this.adapter);
        }
        fi3.b bVar3 = this.binding;
        if (bVar3 != null && (roundCorneredRelativeLayout = bVar3.f399014j) != null) {
            float dp2px = UIUtil.dp2px(roundCorneredRelativeLayout.getContext(), 18.0f);
            roundCorneredRelativeLayout.setRadius(dp2px, dp2px, 0.0f, 0.0f);
        }
        fi3.b bVar4 = this.binding;
        if (bVar4 == null || (imageView = bVar4.f399010f) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RedPacketFragment.uh(RedPacketFragment.this, view);
            }
        });
    }

    private final RedPacketViewModel th() {
        return (RedPacketViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(RedPacketFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().finish();
    }

    private final void wh() {
        ImageView imageView;
        fi3.b bVar = this.binding;
        ImageView imageView2 = bVar != null ? bVar.f399008d : null;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        fi3.b bVar2 = this.binding;
        TextView textView = bVar2 != null ? bVar2.f399009e : null;
        if (textView != null) {
            textView.setVisibility(0);
        }
        fi3.b bVar3 = this.binding;
        View view = bVar3 != null ? bVar3.f399015k : null;
        if (view != null) {
            view.setVisibility(0);
        }
        fi3.b bVar4 = this.binding;
        ImageView imageView3 = bVar4 != null ? bVar4.f399007c : null;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
        fi3.b bVar5 = this.binding;
        if (bVar5 != null && (imageView = bVar5.f399007c) != null) {
            imageView.setImageDrawable(null);
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500L);
        rotateAnimation.setRepeatCount(-1);
        fi3.b bVar6 = this.binding;
        ImageView imageView4 = bVar6 != null ? bVar6.f399008d : null;
        if (imageView4 != null) {
            imageView4.setAnimation(rotateAnimation);
        }
        rotateAnimation.start();
    }

    private final void zh(String text, String color) {
        TextView textView;
        fi3.b bVar = this.binding;
        if (bVar == null || (textView = bVar.f399006b) == null) {
            return;
        }
        textView.setText(text);
        com.tencent.mobileqq.zootopia.redpacket.j.f329071a.g(textView, color);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RedPacketFragment.Ah(RedPacketFragment.this, view);
            }
        });
    }

    public final void Eh(hd3.b data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Ch(data.getHeadBg());
        Ih(data.getTitlePic());
        Dh(data.getListBgColor());
        Hh(data.getSendBtnPic());
        zh(data.getAvatarEntranceText(), data.getAvatarEntranceTextColor());
        Bh(data.getTranslucentColor());
    }

    public final void Fh(String url) {
        fi3.b bVar;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url) || (bVar = this.binding) == null || (imageView = bVar.f399017m) == null) {
            return;
        }
        com.tencent.mobileqq.zootopia.redpacket.j.f329071a.e(imageView, url, Integer.valueOf(UIUtil.dp2px(imageView.getContext(), 140.0f)), Integer.valueOf(UIUtil.dp2px(imageView.getContext(), 210.0f)));
    }

    public final void Gh(View.OnClickListener listener) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(listener, "listener");
        fi3.b bVar = this.binding;
        if (bVar == null || (imageView = bVar.f399018n) == null) {
            return;
        }
        imageView.setOnClickListener(listener);
    }

    public final void Jh(String path, boolean needKeepLoading) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(path)) {
            wh();
            return;
        }
        fi3.b bVar = this.binding;
        if (bVar == null || (imageView = bVar.f399007c) == null) {
            return;
        }
        vh(needKeepLoading);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = UIUtil.dp2px(imageView.getContext(), 140.0f);
        obtain.mRequestHeight = UIUtil.dp2px(imageView.getContext(), 210.0f);
        obtain.mUseSharpPAnimImage = true;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        obtain.mLoadingDrawable = drawable;
        imageView.setImageDrawable(URLDrawable.getFileDrawable(path, obtain));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.isNeedReloadAvatar) {
            this.isNeedReloadAvatar = false;
            this.viewBinder.L();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        th().T1();
        this.viewBinder.u(this, th());
    }

    /* renamed from: rh, reason: from getter */
    public final b getAdapter() {
        return this.adapter;
    }

    /* renamed from: sh, reason: from getter */
    public final fi3.b getBinding() {
        return this.binding;
    }

    public final void xh(long avartarId, int redPacketId, String title, boolean result) {
        Intrinsics.checkNotNullParameter(title, "title");
        e eVar = this.sendingDialog;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (result) {
            Intent intent = new Intent();
            intent.putExtra(IRedPacketApi.RED_PACKET_ID_KEY, redPacketId);
            intent.putExtra(IRedPacketApi.AVATAR_ID_KEY, avartarId);
            intent.putExtra(IRedPacketApi.RED_PACKET_TITLE_KEY, title);
            requireActivity().setResult(-1, intent);
            requireActivity().finish();
        }
    }

    public final void yh() {
        if (this.sendingDialog == null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            this.sendingDialog = new e(requireActivity);
        }
        e eVar = this.sendingDialog;
        if (eVar != null) {
            eVar.show();
        }
    }

    private final void Bh(String color) {
        View view;
        try {
            int parseColor = Color.parseColor(color);
            int[] iArr = {ColorUtils.setAlphaComponent(parseColor, 0), ColorUtils.setAlphaComponent(parseColor, 218), ColorUtils.setAlphaComponent(parseColor, 247)};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(iArr);
            fi3.b bVar = this.binding;
            if (bVar == null || (view = bVar.f399011g) == null) {
                return;
            }
            view.setBackgroundDrawable(gradientDrawable);
        } catch (Exception e16) {
            QLog.e(QBaseFragment.TAG, 1, "setBottomBg error", e16);
        }
    }

    private final void vh(boolean needKeepLoading) {
        ImageView imageView;
        if (!needKeepLoading) {
            fi3.b bVar = this.binding;
            ImageView imageView2 = bVar != null ? bVar.f399008d : null;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            fi3.b bVar2 = this.binding;
            TextView textView = bVar2 != null ? bVar2.f399009e : null;
            if (textView != null) {
                textView.setVisibility(4);
            }
            fi3.b bVar3 = this.binding;
            View view = bVar3 != null ? bVar3.f399015k : null;
            if (view != null) {
                view.setVisibility(4);
            }
            fi3.b bVar4 = this.binding;
            if (bVar4 != null && (imageView = bVar4.f399008d) != null) {
                imageView.clearAnimation();
            }
        }
        fi3.b bVar5 = this.binding;
        ImageView imageView3 = bVar5 != null ? bVar5.f399007c : null;
        if (imageView3 == null) {
            return;
        }
        imageView3.setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        fi3.b g16 = fi3.b.g(inflater, container, false);
        id3.d dVar = this.reporter;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "root");
        dVar.j(requireActivity, root, "pg_zplan_hongbao_cover_list", new LinkedHashMap());
        id3.d dVar2 = this.reporter;
        TextView avatarEntrance = g16.f399006b;
        Intrinsics.checkNotNullExpressionValue(avatarEntrance, "avatarEntrance");
        id3.d.h(dVar2, avatarEntrance, "em_zplan_entrance_hongbao_cover", new LinkedHashMap(), false, false, null, 56, null);
        id3.d dVar3 = this.reporter;
        ImageView back = g16.f399010f;
        Intrinsics.checkNotNullExpressionValue(back, "back");
        id3.d.h(dVar3, back, "em_zplan_hongbao_cover_back", new LinkedHashMap(), false, false, null, 56, null);
        id3.d dVar4 = this.reporter;
        ImageView sendBtn = g16.f399018n;
        Intrinsics.checkNotNullExpressionValue(sendBtn, "sendBtn");
        id3.d.i(dVar4, sendBtn, "em_zplan_hongbao_cover_send", new LinkedHashMap(), false, false, null, false, false, 240, null);
        id3.d dVar5 = this.reporter;
        ImageView displayBg = g16.f399013i;
        Intrinsics.checkNotNullExpressionValue(displayBg, "displayBg");
        id3.d.i(dVar5, displayBg, "em_zplan_hongbao_cover_loading_fail_alert", new LinkedHashMap(), false, false, null, false, false, 224, null);
        id3.d dVar6 = this.reporter;
        View bottomBg = g16.f399011g;
        Intrinsics.checkNotNullExpressionValue(bottomBg, "bottomBg");
        id3.d.i(dVar6, bottomBg, "em_zplan_hongbao_cover_send_fail_alert", new LinkedHashMap(), false, false, null, false, false, 224, null);
        this.binding = g16;
        return g16.getRoot();
    }
}
