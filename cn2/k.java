package cn2;

import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.DownloadState;
import com.tencent.mobileqq.richmedialist.model.FileItemInfo;
import com.tencent.mobileqq.richmedialist.widget.ProgressIcon;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J*\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0002J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u0019\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcn2/k;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/richmedialist/model/FileItemInfo;", "Landroid/view/View$OnClickListener;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "fileItemInfo", "Lkotlin/Pair;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", NodeProps.ON_CLICK, "d", "Ljava/lang/String;", "TAG", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "e", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkBox", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "iconView", "Lcom/tencent/biz/qui/profileskin/widget/QUITextView;", tl.h.F, "Lcom/tencent/biz/qui/profileskin/widget/QUITextView;", "nameText", "i", "descText", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "fileStateView", "Lcom/tencent/mobileqq/richmedialist/widget/ProgressIcon;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/richmedialist/widget/ProgressIcon;", "processIcon", "D", "Landroid/view/View;", "fileContextView", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k extends Section<FileItemInfo> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ProgressIcon processIcon;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View fileContextView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "FileSection";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUICheckBox checkBox;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundCornerImageView iconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUITextView nameText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUITextView descText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView fileStateView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(FileItemInfo it, RoundCornerImageView it12, an2.b bVar) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(it12, "$it1");
        if (bVar != null) {
            bVar.xf(it, it12, it12.getWidth(), it12.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(k this$0, View view, an2.b bVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUICheckBox qUICheckBox = this$0.checkBox;
        if (qUICheckBox != null) {
            z16 = qUICheckBox.isChecked();
        } else {
            z16 = false;
        }
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.richmedialist.model.BaseItemInfo");
        bVar.T1(z16, (BaseItemInfo) tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(View view, an2.b bVar) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.richmedialist.model.BaseItemInfo");
        bVar.Vb((BaseItemInfo) tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View view, an2.b bVar) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.richmedialist.model.BaseItemInfo");
        bVar.kf((BaseItemInfo) tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(View view, an2.b bVar) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.richmedialist.model.BaseItemInfo");
        bVar.Qb((BaseItemInfo) tag);
    }

    @NotNull
    public final Pair<Integer, String> A(@NotNull FileItemInfo fileItemInfo) {
        Intrinsics.checkNotNullParameter(fileItemInfo, "fileItemInfo");
        if ((fileItemInfo.getDownloadState() == DownloadState.COMPLETE && FileUtils.fileExists(fileItemInfo.getLocalSavePath())) || fileItemInfo.getIsShow()) {
            return new Pair<>(0, "");
        }
        if (fileItemInfo.getDownloadState() != DownloadState.DOWNLOADING && fileItemInfo.getDownloadState() != DownloadState.PAUSE) {
            if (fileItemInfo.getDownloadState() == DownloadState.FAIL) {
                Integer valueOf = Integer.valueOf(R.drawable.qui_caution_filled_feedback_error);
                String string = getRootView().getResources().getString(R.string.zwa);
                Intrinsics.checkNotNullExpressionValue(string, "rootView.resources.getSt\u2026xport_file_download_fail)");
                return new Pair<>(valueOf, string);
            }
            Integer valueOf2 = Integer.valueOf(R.drawable.jm9);
            String string2 = getRootView().getResources().getString(R.string.zw9);
            Intrinsics.checkNotNullExpressionValue(string2, "rootView.resources.getSt\u2026ing.export_file_download)");
            return new Pair<>(valueOf2, string2);
        }
        Integer valueOf3 = Integer.valueOf(R.drawable.jm8);
        String string3 = getRootView().getResources().getString(R.string.f170906zw3);
        Intrinsics.checkNotNullExpressionValue(string3, "rootView.resources.getSt\u2026ort_file_cancel_download)");
        return new Pair<>(valueOf3, string3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f74283vu};
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable final View v3) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            obj = v3.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof BaseItemInfo) {
            int id5 = v3.getId();
            if (id5 == R.id.f165203v54) {
                RFWIocAbilityProvider.g().getIoc(an2.b.class).withGlobal(v3.getContext()).done(new OnPromiseResolved() { // from class: cn2.g
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj2) {
                        k.w(k.this, v3, (an2.b) obj2);
                    }
                }).run();
            } else if (id5 == R.id.c_u) {
                RFWIocAbilityProvider.g().getIoc(an2.b.class).withGlobal(v3.getContext()).done(new OnPromiseResolved() { // from class: cn2.h
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj2) {
                        k.x(v3, (an2.b) obj2);
                    }
                }).run();
            } else if (id5 == R.id.f247209w) {
                RFWIocAbilityProvider.g().getIoc(an2.b.class).withGlobal(v3.getContext()).done(new OnPromiseResolved() { // from class: cn2.i
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj2) {
                        k.y(v3, (an2.b) obj2);
                    }
                }).run();
            } else if (id5 == R.id.v56) {
                if (v3.getTag() instanceof FileItemInfo) {
                    Object tag = v3.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.richmedialist.model.FileItemInfo");
                    if (((FileItemInfo) tag).getIsShow()) {
                        QUICheckBox qUICheckBox = this.checkBox;
                        if (qUICheckBox != null) {
                            qUICheckBox.performClick();
                        }
                    }
                }
                RFWIocAbilityProvider.g().getIoc(an2.b.class).withGlobal(v3.getContext()).done(new OnPromiseResolved() { // from class: cn2.j
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj2) {
                        k.z(v3, (an2.b) obj2);
                    }
                }).run();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        QUICheckBox qUICheckBox;
        RoundCornerImageView roundCornerImageView;
        QUITextView qUITextView;
        QUITextView qUITextView2;
        ProgressIcon progressIcon;
        ImageView imageView;
        View view = null;
        if (containerView != null) {
            qUICheckBox = (QUICheckBox) containerView.findViewById(R.id.f165203v54);
        } else {
            qUICheckBox = null;
        }
        this.checkBox = qUICheckBox;
        if (qUICheckBox != null) {
            qUICheckBox.setOnClickListener(this);
        }
        if (containerView != null) {
            roundCornerImageView = (RoundCornerImageView) containerView.findViewById(R.id.c_u);
        } else {
            roundCornerImageView = null;
        }
        this.iconView = roundCornerImageView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setCorner(ViewUtils.dpToPx(6.0f));
        }
        RoundCornerImageView roundCornerImageView2 = this.iconView;
        if (roundCornerImageView2 != null) {
            roundCornerImageView2.setOnClickListener(this);
        }
        if (containerView != null) {
            qUITextView = (QUITextView) containerView.findViewById(R.id.c_x);
        } else {
            qUITextView = null;
        }
        this.nameText = qUITextView;
        if (containerView != null) {
            qUITextView2 = (QUITextView) containerView.findViewById(R.id.v57);
        } else {
            qUITextView2 = null;
        }
        this.descText = qUITextView2;
        if (containerView != null) {
            progressIcon = (ProgressIcon) containerView.findViewById(R.id.f247209w);
        } else {
            progressIcon = null;
        }
        this.processIcon = progressIcon;
        if (containerView != null) {
            imageView = (ImageView) containerView.findViewById(R.id.v5e);
        } else {
            imageView = null;
        }
        this.fileStateView = imageView;
        ProgressIcon progressIcon2 = this.processIcon;
        if (progressIcon2 != null) {
            progressIcon2.setOnClickListener(this);
        }
        if (containerView != null) {
            view = containerView.findViewById(R.id.v56);
        }
        this.fileContextView = view;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final FileItemInfo data, int position, @Nullable List<Object> payload) {
        if (data != null) {
            if (data.getIsShow()) {
                QUICheckBox qUICheckBox = this.checkBox;
                if (qUICheckBox != null) {
                    qUICheckBox.setChecked(data.getIsChecked());
                }
                QUICheckBox qUICheckBox2 = this.checkBox;
                if (qUICheckBox2 != null) {
                    qUICheckBox2.setVisibility(0);
                }
                QUICheckBox qUICheckBox3 = this.checkBox;
                if (qUICheckBox3 != null) {
                    qUICheckBox3.setTag(data);
                }
            } else {
                QUICheckBox qUICheckBox4 = this.checkBox;
                if (qUICheckBox4 != null) {
                    qUICheckBox4.setVisibility(8);
                }
            }
            if (data.getResId() != 0) {
                RoundCornerImageView roundCornerImageView = this.iconView;
                if (roundCornerImageView != null) {
                    roundCornerImageView.setImageResource(data.getResId());
                }
            } else {
                final RoundCornerImageView roundCornerImageView2 = this.iconView;
                if (roundCornerImageView2 != null) {
                    RFWIocAbilityProvider.g().getIoc(an2.b.class).withGlobal(roundCornerImageView2.getContext()).done(new OnPromiseResolved() { // from class: cn2.f
                        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                        public final void onDone(Object obj) {
                            k.v(FileItemInfo.this, roundCornerImageView2, (an2.b) obj);
                        }
                    }).run();
                }
            }
            RoundCornerImageView roundCornerImageView3 = this.iconView;
            if (roundCornerImageView3 != null) {
                roundCornerImageView3.setTag(data);
            }
            View view = this.fileContextView;
            if (view != null) {
                view.setTag(data);
            }
            dn2.d dVar = dn2.d.f394315a;
            dVar.a(data.getFileName(), this.nameText);
            dVar.a(data.getFileTime(), this.descText);
            Pair<Integer, String> A = A(data);
            int intValue = A.getFirst().intValue();
            if (intValue <= 0) {
                ProgressIcon progressIcon = this.processIcon;
                if (progressIcon != null) {
                    progressIcon.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView = this.fileStateView;
            if (imageView != null) {
                imageView.setImageResource(intValue);
            }
            ImageView imageView2 = this.fileStateView;
            if (imageView2 != null) {
                imageView2.setContentDescription(A.getSecond());
            }
            ProgressIcon progressIcon2 = this.processIcon;
            if (progressIcon2 != null) {
                progressIcon2.setVisibility(0);
            }
            ProgressIcon progressIcon3 = this.processIcon;
            if (progressIcon3 != null) {
                progressIcon3.c(data.getDownloadProgress());
            }
            ProgressIcon progressIcon4 = this.processIcon;
            if (progressIcon4 != null) {
                progressIcon4.setVisibility(0);
            }
            ProgressIcon progressIcon5 = this.processIcon;
            if (progressIcon5 != null) {
                progressIcon5.setTag(data);
            }
        }
    }
}
