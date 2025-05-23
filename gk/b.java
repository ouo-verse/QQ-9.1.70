package gk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.l;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.intimate.bean.QZoneAlbumSyncBean;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.ae;
import qj.d;
import qzone.QZoneBaseMeta$StPicUrl;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0003J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J*\u0010\u0019\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0010H\u0016R\u0014\u0010\u001e\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010-R\u0016\u00101\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010-R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lgk/b;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumSyncBean;", "Landroid/view/View$OnClickListener;", "", "v", "y", HippyTKDListViewAdapter.X, "w", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", BdhLogUtil.LogTag.Tag_Conn, "view", NodeProps.ON_CLICK, "e", "Ljava/lang/String;", "TAG", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "mItemView", "Landroid/widget/CheckBox;", h.F, "Landroid/widget/CheckBox;", "mAlbumCheckView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "i", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "mAlbumPicView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mAlbumNameView", "mAlbumCountView", "D", "mAlbumSyncedView", "Lnk/ae;", "E", "Lnk/ae;", "mAlbumViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<QZoneAlbumSyncBean> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mAlbumCountView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mAlbumSyncedView;

    /* renamed from: E, reason: from kotlin metadata */
    private ae mAlbumViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateAlbumSyncContentSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mItemView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CheckBox mAlbumCheckView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView mAlbumPicView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumNameView;

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        ((QZoneAlbumSyncBean) this.mData).setSelected(!((QZoneAlbumSyncBean) r0).getIsSelected());
        int p16 = g.f53821a.h().p();
        ae aeVar = this.mAlbumViewModel;
        CheckBox checkBox = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        if (aeVar.W1().size() == p16 - 1) {
            ae aeVar2 = this.mAlbumViewModel;
            if (aeVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                aeVar2 = null;
            }
            aeVar2.f2(false);
        } else {
            ae aeVar3 = this.mAlbumViewModel;
            if (aeVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                aeVar3 = null;
            }
            if (aeVar3.W1().size() == p16) {
                ae aeVar4 = this.mAlbumViewModel;
                if (aeVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    aeVar4 = null;
                }
                aeVar4.f2(true);
            } else {
                ae aeVar5 = this.mAlbumViewModel;
                if (aeVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    aeVar5 = null;
                }
                if (aeVar5.W1().size() > p16) {
                    ((QZoneAlbumSyncBean) this.mData).setSelected(false);
                    ae aeVar6 = this.mAlbumViewModel;
                    if (aeVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                        aeVar6 = null;
                    }
                    aeVar6.f2(true);
                    QQToastUtil.showQQToastInUiThread(3, "\u6700\u591a\u53ea\u80fd\u540c\u6b6510\u4e2a\u76f8\u518c");
                }
            }
        }
        v();
        QZoneAlbumSyncBean qZoneAlbumSyncBean = (QZoneAlbumSyncBean) this.mData;
        CheckBox checkBox2 = this.mAlbumCheckView;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
        } else {
            checkBox = checkBox2;
        }
        qZoneAlbumSyncBean.setSelected(checkBox.isChecked());
        d dVar = (d) q(d.class);
        if (dVar != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            dVar.F2((QZoneAlbumSyncBean) mData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean B() {
        return ((QZoneAlbumSyncBean) this.mData).getAlbumInfo().status.get() == 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        CheckBox checkBox = null;
        if (((QZoneAlbumSyncBean) this.mData).getAlbumInfo().upload_number.get() <= g.f53821a.h().q() && !B()) {
            if (((QZoneAlbumSyncBean) this.mData).getIsSelected()) {
                CheckBox checkBox2 = this.mAlbumCheckView;
                if (checkBox2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
                    checkBox2 = null;
                }
                checkBox2.setBackgroundResource(R.drawable.qui_common_checkbox_selector_72_noskin);
                CheckBox checkBox3 = this.mAlbumCheckView;
                if (checkBox3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
                    checkBox3 = null;
                }
                checkBox3.setChecked(true);
                CheckBox checkBox4 = this.mAlbumCheckView;
                if (checkBox4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
                } else {
                    checkBox = checkBox4;
                }
                checkBox.setEnabled(true);
                return;
            }
            if (((QZoneAlbumSyncBean) this.mData).getIsDisable()) {
                CheckBox checkBox5 = this.mAlbumCheckView;
                if (checkBox5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
                    checkBox5 = null;
                }
                checkBox5.setBackgroundResource(R.drawable.qui_common_check_box_unchecked_disable);
                CheckBox checkBox6 = this.mAlbumCheckView;
                if (checkBox6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
                    checkBox6 = null;
                }
                checkBox6.setChecked(false);
                CheckBox checkBox7 = this.mAlbumCheckView;
                if (checkBox7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
                } else {
                    checkBox = checkBox7;
                }
                checkBox.setEnabled(false);
                return;
            }
            CheckBox checkBox8 = this.mAlbumCheckView;
            if (checkBox8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
                checkBox8 = null;
            }
            checkBox8.setBackgroundResource(R.drawable.qui_common_checkbox_selector_72_noskin);
            CheckBox checkBox9 = this.mAlbumCheckView;
            if (checkBox9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
                checkBox9 = null;
            }
            checkBox9.setChecked(false);
            CheckBox checkBox10 = this.mAlbumCheckView;
            if (checkBox10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
            } else {
                checkBox = checkBox10;
            }
            checkBox.setEnabled(true);
            return;
        }
        CheckBox checkBox11 = this.mAlbumCheckView;
        if (checkBox11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
            checkBox11 = null;
        }
        checkBox11.setBackgroundResource(R.drawable.qui_common_check_box_unchecked_disable);
        CheckBox checkBox12 = this.mAlbumCheckView;
        if (checkBox12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
            checkBox12 = null;
        }
        checkBox12.setChecked(false);
        CheckBox checkBox13 = this.mAlbumCheckView;
        if (checkBox13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumCheckView");
        } else {
            checkBox = checkBox13;
        }
        checkBox.setEnabled(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        TextView textView = this.mAlbumCountView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumCountView");
            textView = null;
        }
        PBUInt64Field pBUInt64Field = ((QZoneAlbumSyncBean) this.mData).getAlbumInfo().upload_number;
        textView.setText((pBUInt64Field != null ? Long.valueOf(pBUInt64Field.get()) : null) + "\u5f20");
        TextView textView3 = this.mAlbumSyncedView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncedView");
        } else {
            textView2 = textView3;
        }
        textView2.setVisibility(B() ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        TextView textView = this.mAlbumNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumNameView");
            textView = null;
        }
        PBStringField pBStringField = ((QZoneAlbumSyncBean) this.mData).getAlbumInfo().name;
        textView.setText(pBStringField != null ? pBStringField.get() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        QZoneBaseMeta$StPicUrl e16 = ij.h.e(((QZoneAlbumSyncBean) this.mData).getAlbumInfo());
        RoundCornerImageView roundCornerImageView = null;
        if (!ij.h.f(e16)) {
            RoundCornerImageView roundCornerImageView2 = this.mAlbumPicView;
            if (roundCornerImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            } else {
                roundCornerImageView = roundCornerImageView2;
            }
            roundCornerImageView.setImageResource(R.drawable.asd);
            RFWLog.e(this.TAG, RFWLog.USR, "bindPicView stPicUrl is null");
            return;
        }
        Intrinsics.checkNotNull(e16);
        Option e17 = c.e(e16.url.get());
        RoundCornerImageView roundCornerImageView3 = this.mAlbumPicView;
        if (roundCornerImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
        } else {
            roundCornerImageView = roundCornerImageView3;
        }
        e17.setTargetView(roundCornerImageView);
        e17.setLoadingDrawable(p().getResources().getDrawable(R.drawable.asd));
        e17.setFailDrawable(p().getResources().getDrawable(R.drawable.asd));
        c.a().i(e17, new IPicLoadStateListener() { // from class: gk.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                b.z(b.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(b this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!loadState.isFinishError() || option == null) {
            return;
        }
        RFWLog.e(this$0.TAG, RFWLog.USR, "loadImage | state = " + loadState + " | url = " + option.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.f162879n41) {
            A();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f162879n41);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026imate_album_sync_content)");
        this.mItemView = (ViewGroup) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n3t);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026qzone_intimate_album_pic)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById2;
        this.mAlbumPicView = roundCornerImageView;
        ViewGroup viewGroup = null;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            roundCornerImageView = null;
        }
        roundCornerImageView.setCorner(ar.d(8.0f));
        View findViewById3 = containerView.findViewById(R.id.n3i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026one_intimate_album_check)");
        this.mAlbumCheckView = (CheckBox) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.n3s);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026zone_intimate_album_name)");
        this.mAlbumNameView = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.n3k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026one_intimate_album_count)");
        this.mAlbumCountView = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.n4_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026mate_album_synced_status)");
        this.mAlbumSyncedView = (TextView) findViewById6;
        ViewGroup viewGroup2 = this.mItemView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setOnClickListener(this);
        ViewModel t16 = t(ae.class);
        Intrinsics.checkNotNullExpressionValue(t16, "getViewModel(QZoneIntima\u2026yncViewModel::class.java)");
        this.mAlbumViewModel = (ae) t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlv};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZoneAlbumSyncBean data, int position, List<Object> payload) {
        if (data != null) {
            v();
            y();
            x();
            w();
        }
    }
}
