package com.qzone.reborn.albumx.qzonex.part.invite;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.InviteJoinStatus;
import com.tencent.widget.RoundRectImageView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nc.bf;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u0018\u00104\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/invite/QZAlbumxInviteHeadPart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "M9", "initData", "R9", "Lab/a;", "rsp", "J9", "T9", "V9", "S9", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "", "I9", "", "P9", "Q9", "O9", "X9", "U9", "W9", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "d", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "Lcom/tencent/widget/RoundRectImageView;", "e", "Lcom/tencent/widget/RoundRectImageView;", "coverIV", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "backIV", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "numberTV", "i", "albumTipsTV", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "countTV", BdhLogUtil.LogTag.Tag_Conn, "nickTV", "Lnc/bf;", "D", "Lnc/bf;", "inviteViewModel", "E", "Ljava/lang/String;", "DEFAULT_HEAD_URL", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxInviteHeadPart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView nickTV;

    /* renamed from: D, reason: from kotlin metadata */
    private bf inviteViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private final String DEFAULT_HEAD_URL = "https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/groupphoto-cover.png";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView coverIV;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView backIV;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView numberTV;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView albumTipsTV;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView countTV;

    private final String I9(CommonAlbumInfo albumInfo) {
        String format;
        String name = albumInfo.getName();
        if (name == null || name.length() == 0) {
            return "";
        }
        if (P9()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.je_);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026albumx_invite_album_tips)");
            format = String.format(string, Arrays.copyOf(new Object[]{name}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        } else if (O9()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getContext().getString(R.string.jf8);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_invite_album_tips_apply)");
            format = String.format(string2, Arrays.copyOf(new Object[]{name}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        } else if (Q9()) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String string3 = getContext().getString(R.string.jf_);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026nvite_album_tips_success)");
            format = String.format(string3, Arrays.copyOf(new Object[]{name}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        } else {
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String string4 = getContext().getString(R.string.jf9);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026nvite_album_tips_default)");
            format = String.format(string4, Arrays.copyOf(new Object[]{name}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        QLog.i("QZAlbumxInviteHeadPart", 2, "albumTips text:" + format);
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(ab.a rsp) {
        T9(rsp);
        V9(rsp);
        W9(rsp);
        S9(rsp);
        X9(rsp);
        U9(rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZAlbumxInviteHeadPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean O9() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 0) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            } else {
                bfVar2 = bfVar3;
            }
            if (bfVar2.n2()) {
                return true;
            }
        }
        return false;
    }

    private final boolean P9() {
        Integer value;
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 1) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar3 = null;
            }
            if (bfVar3.o2()) {
                bf bfVar4 = this.inviteViewModel;
                if (bfVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar4 = null;
                }
                ab.a value2 = bfVar4.c2().getValue();
                if (value2 != null && value2.getInviteStatus() == InviteJoinStatus.KINVITESTATUSPENDING.ordinal()) {
                    bf bfVar5 = this.inviteViewModel;
                    if (bfVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    } else {
                        bfVar2 = bfVar5;
                    }
                    MutableLiveData<Integer> h26 = bfVar2.h2();
                    if (!((h26 == null || (value = h26.getValue()) == null || value.intValue() != 3) ? false : true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean Q9() {
        Integer value;
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 1) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar3 = null;
            }
            if (bfVar3.o2()) {
                bf bfVar4 = this.inviteViewModel;
                if (bfVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar4 = null;
                }
                ab.a value2 = bfVar4.c2().getValue();
                if (value2 != null && value2.getInviteStatus() == InviteJoinStatus.KINVITESTATUSPASSED.ordinal()) {
                    return true;
                }
                bf bfVar5 = this.inviteViewModel;
                if (bfVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                } else {
                    bfVar2 = bfVar5;
                }
                MutableLiveData<Integer> h26 = bfVar2.h2();
                if ((h26 == null || (value = h26.getValue()) == null || value.intValue() != 3) ? false : true) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void R9() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.g2().getPageType() == 1) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            } else {
                bfVar2 = bfVar3;
            }
            bfVar2.d2();
            return;
        }
        bf bfVar4 = this.inviteViewModel;
        if (bfVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar4;
        }
        bfVar2.X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(ab.a rsp) {
        TextView textView = this.albumTipsTV;
        if (textView == null) {
            return;
        }
        textView.setText(I9(rsp.getAlbumInfo()));
    }

    private final void T9(ab.a rsp) {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.n2()) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar3 = null;
            }
            if (bfVar3.g2().getPageType() == 0) {
                QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
                if (qZoneUserAvatarView != null) {
                    qZoneUserAvatarView.setUser(ef.d.k(rsp.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin()));
                    return;
                }
                return;
            }
        }
        QZoneUserAvatarView qZoneUserAvatarView2 = this.avatarView;
        if (qZoneUserAvatarView2 != null) {
            bf bfVar4 = this.inviteViewModel;
            if (bfVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            } else {
                bfVar2 = bfVar4;
            }
            qZoneUserAvatarView2.setUser(ef.d.k(bfVar2.g2().getAlbumOwner()));
        }
    }

    private final void U9(ab.a rsp) {
        TextView textView = this.countTV;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(rsp.getAlbumInfo().getUploadNumber()));
    }

    private final void V9(ab.a rsp) {
        String str;
        if (this.coverIV == null) {
            QLog.e("QZAlbumxInviteHeadPart", 1, "updateCover coverIV = null");
            return;
        }
        String e16 = k9.a.e(rsp.getAlbumInfo().getCover(), 0, 1, null);
        if (e16 == null || e16.length() == 0) {
            CommonStPicUrl f16 = k9.a.f(rsp.getAlbumInfo());
            if (f16 == null || (str = f16.getUrl()) == null) {
                str = "";
            }
            e16 = str;
        }
        if (TextUtils.isEmpty(e16)) {
            QLog.e("QZAlbumxInviteHeadPart", 1, "updateCover error,coverUrl = null, use default url");
            e16 = this.DEFAULT_HEAD_URL;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(e16);
        obtain.setTargetView(this.coverIV);
        obtain.setLoadingDrawable(getActivity().getResources().getDrawable(R.drawable.at8, null));
        obtain.setFailDrawable(getActivity().getResources().getDrawable(R.drawable.at_, null));
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    private final void W9(ab.a rsp) {
        String a16;
        TextView textView = this.nickTV;
        if (textView == null) {
            return;
        }
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        if (bfVar.n2()) {
            bf bfVar3 = this.inviteViewModel;
            if (bfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                bfVar3 = null;
            }
            if (bfVar3.g2().getPageType() == 0) {
                a16 = com.qzone.reborn.albumx.qzonex.utils.j.f53413a.a(rsp.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), rsp.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getNick());
                textView.setText(a16);
            }
        }
        com.qzone.reborn.albumx.qzonex.utils.j jVar = com.qzone.reborn.albumx.qzonex.utils.j.f53413a;
        bf bfVar4 = this.inviteViewModel;
        if (bfVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar4;
        }
        a16 = jVar.a(bfVar2.g2().getAlbumOwner(), "");
        textView.setText(a16);
    }

    private final void X9(ab.a rsp) {
        TextView textView = this.numberTV;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(rsp.getAlbumInfo().getShareAlbum().getShareNums()));
    }

    private final void initData() {
        bf bfVar = this.inviteViewModel;
        bf bfVar2 = null;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        MutableLiveData<ab.a> c26 = bfVar.c2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<ab.a, Unit> function1 = new Function1<ab.a, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteHeadPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ab.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ab.a it) {
                QZAlbumxInviteHeadPart qZAlbumxInviteHeadPart = QZAlbumxInviteHeadPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZAlbumxInviteHeadPart.J9(it);
            }
        };
        c26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxInviteHeadPart.K9(Function1.this, obj);
            }
        });
        bf bfVar3 = this.inviteViewModel;
        if (bfVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
        } else {
            bfVar2 = bfVar3;
        }
        MutableLiveData<Integer> h26 = bfVar2.h2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.QZAlbumxInviteHeadPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                bf bfVar4;
                bfVar4 = QZAlbumxInviteHeadPart.this.inviteViewModel;
                if (bfVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
                    bfVar4 = null;
                }
                ab.a value = bfVar4.c2().getValue();
                if (value != null) {
                    QZAlbumxInviteHeadPart.this.S9(value);
                }
            }
        };
        h26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxInviteHeadPart.L9(Function1.this, obj);
            }
        });
        R9();
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(bf.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxInviteViewModel::class.java)");
        bf bfVar = (bf) viewModel;
        this.inviteViewModel = bfVar;
        if (bfVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteViewModel");
            bfVar = null;
        }
        bfVar.w2(getActivity().getIntent());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxInviteHeadPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        M9(rootView);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }

    private final void M9(View rootView) {
        this.avatarView = rootView != null ? (QZoneUserAvatarView) rootView.findViewById(R.id.f19094r) : null;
        this.backIV = rootView != null ? (ImageView) rootView.findViewById(R.id.kua) : null;
        this.coverIV = rootView != null ? (RoundRectImageView) rootView.findViewById(R.id.f18733s) : null;
        this.numberTV = rootView != null ? (TextView) rootView.findViewById(R.id.f188140) : null;
        this.countTV = rootView != null ? (TextView) rootView.findViewById(R.id.f18723r) : null;
        this.albumTipsTV = rootView != null ? (TextView) rootView.findViewById(R.id.f188241) : null;
        this.nickTV = rootView != null ? (TextView) rootView.findViewById(R.id.mhd) : null;
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setIsShieldJumpToMainPage(true);
        }
        ImageView imageView = this.backIV;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.invite.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxInviteHeadPart.N9(QZAlbumxInviteHeadPart.this, view);
                }
            });
        }
        RoundRectImageView roundRectImageView = this.coverIV;
        if (roundRectImageView != null) {
            roundRectImageView.setCornerRadiusAndMode(ar.d(8.0f), 1);
        }
    }
}
