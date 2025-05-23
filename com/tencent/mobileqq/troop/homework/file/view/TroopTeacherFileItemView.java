package com.tencent.mobileqq.troop.homework.file.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.bb;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileAdapter;
import com.tencent.mobileqq.troop.homework.file.vm.TroopTeacherFileVM;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qzone.QZoneHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B9\b\u0007\u0012\u0006\u0010%\u001a\u00020 \u0012\b\u0010)\u001a\u0004\u0018\u00010&\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010H\u001a\u00020\u0014\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\u001c\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010)\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b#\u0010'\u001a\u0004\b!\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileItemView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", "c", DomainData.DOMAIN_NAME, "Landroid/text/SpannableString;", "spannableString", "", "detailInfo", "clickableText", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "k", "f", "Lcom/tencent/mobileqq/troop/data/n;", "troopFileInfo", "", "progressBarShow", "", "fileState", "j", "g", h.F, "", "", "payloads", "p", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;", "d", "Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;", "e", "()Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;", "viewModel", "Landroid/app/Activity;", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/filemanager/widget/AsyncImageView;", "Lcom/tencent/mobileqq/filemanager/widget/AsyncImageView;", "coverImageView", "Lcom/tencent/mobileqq/widget/CircleFileStateView;", "Lcom/tencent/mobileqq/widget/CircleFileStateView;", "downloadStatusView", "Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;", "Lcom/tencent/mobileqq/troop/widget/EllipsizingTextView;", "fileNameTextView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "successIcon", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "detailTextView", "D", "Lcom/tencent/mobileqq/troop/data/n;", "Landroid/util/SparseIntArray;", "E", "Landroid/util/SparseIntArray;", "mFileViewStatusArray", "Lcom/tencent/mobileqq/troop/data/TroopFileItemOperation;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/data/TroopFileItemOperation;", "mItemOperation", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;Landroid/app/Activity;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopTeacherFileItemView extends FrameLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView detailTextView;

    /* renamed from: D, reason: from kotlin metadata */
    private n troopFileInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private SparseIntArray mFileViewStatusArray;

    /* renamed from: F, reason: from kotlin metadata */
    private TroopFileItemOperation mItemOperation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopTeacherFileVM viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AsyncImageView coverImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CircleFileStateView downloadStatusView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EllipsizingTextView fileNameTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView successIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/homework/file/view/TroopTeacherFileItemView$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intent intent = new Intent();
            TroopTeacherFileItemView troopTeacherFileItemView = TroopTeacherFileItemView.this;
            intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, troopTeacherFileItemView.getViewModel().getTroopUin());
            intent.putExtra("folderPath", "/");
            intent.putExtra("filter_uin", troopTeacherFileItemView.troopFileInfo.f294920f);
            intent.putExtra("filter_member_name", troopTeacherFileItemView.troopFileInfo.g());
            intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 4000);
            Activity activity = TroopTeacherFileItemView.this.getActivity();
            if (activity != null) {
                ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage(activity, intent, 0);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setColor(Color.parseColor("#0099FF"));
            ds5.setUnderlineText(false);
        }
    }

    public /* synthetic */ TroopTeacherFileItemView(TroopTeacherFileVM troopTeacherFileVM, Activity activity, Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(troopTeacherFileVM, activity, context, (i16 & 8) != 0 ? null : attributeSet, (i16 & 16) != 0 ? 0 : i3);
    }

    private final void c() {
        n();
        m();
        o();
        k();
    }

    private final void h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        t fileStatusInfo = this.mItemOperation.r(this.troopFileInfo);
        int q16 = this.mItemOperation.q(this.troopFileInfo);
        int X = QFileUtils.X(q16, 4);
        n nVar = this.troopFileInfo;
        long j3 = nVar.f294923i;
        String valueOf = String.valueOf(nVar.f294920f);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.checkNotNullExpressionValue(fileStatusInfo, "fileStatusInfo");
        bb.q(qQAppInterface, context, fileStatusInfo, q16, X, j3, valueOf, true, false, false, 0L, this.troopFileInfo.f294927m);
    }

    private final void j(n troopFileInfo, boolean progressBarShow, int fileState) {
        this.downloadStatusView.setVisibility(progressBarShow ? 0 : 8);
        if (fileState == -1) {
            this.downloadStatusView.setVisibility(8);
            return;
        }
        this.downloadStatusView.setVisibility(0);
        this.downloadStatusView.setState(fileState);
        if (fileState == 1) {
            this.downloadStatusView.setContentDescription(HardCodeUtil.qqStr(R.string.ufz));
        } else if (fileState == 2) {
            this.downloadStatusView.setContentDescription(HardCodeUtil.qqStr(R.string.ufc));
        } else if (fileState != 3) {
            this.downloadStatusView.setContentDescription("");
        } else {
            this.downloadStatusView.setContentDescription(HardCodeUtil.qqStr(R.string.uft));
        }
        long j3 = troopFileInfo.f294932r;
        long j16 = troopFileInfo.f294918d;
        if (j3 > j16) {
            j3 = j16;
        }
        while (j16 > TTL.MAX_VALUE) {
            j16 >>= 1;
            j3 >>= 1;
        }
        this.downloadStatusView.setProgress((int) ((j3 * 100.0d) / j16));
    }

    private final void k() {
        int i3 = this.troopFileInfo.f294930p;
        boolean z16 = true;
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 8 && i3 != 9) {
            z16 = false;
        }
        j(this.troopFileInfo, z16, this.mFileViewStatusArray.get(i3, -1));
        this.downloadStatusView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.file.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeacherFileItemView.l(TroopTeacherFileItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(TroopTeacherFileItemView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    private final void m() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopFileTransferManager O = TroopFileTransferManager.O(peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null, Long.parseLong(this.viewModel.getTroopUin()));
        n nVar = this.troopFileInfo;
        if (nVar.f294937w == null) {
            O.D(nVar.f294915a, 128);
        }
        if (FileUtils.fileExistsAndNotEmpty(this.troopFileInfo.f294937w)) {
            FileManagerUtil.setFileIcon(this.coverImageView, this.troopFileInfo.f294937w, FileManagerUtil.getFileType(this.troopFileInfo.f294917c));
        } else {
            this.coverImageView.setDefaultImage(FileManagerUtil.getFileIconResId(this.troopFileInfo.f294917c));
        }
        this.coverImageView.setContentDescription(HardCodeUtil.qqStr(R.string.f172817ug3));
    }

    private final void n() {
        this.fileNameTextView.setText(this.troopFileInfo.f294917c);
        this.fileNameTextView.setMaxLines(2);
        this.fileNameTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        n nVar = this.troopFileInfo;
        String str = nVar.E + " \u6765\u81ea " + nVar.g() + " " + this.troopFileInfo.e();
        SpannableString spannableString = new SpannableString(str);
        String g16 = this.troopFileInfo.g();
        Intrinsics.checkNotNullExpressionValue(g16, "troopFileInfo.uploaderName");
        i(spannableString, str, g16);
        this.detailTextView.setText(spannableString);
        this.detailTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void o() {
        n nVar = this.troopFileInfo;
        int i3 = nVar.f294930p;
        if (i3 != 11 && i3 != 6) {
            this.successIcon.setVisibility(8);
        } else if (q.f(nVar.f294934t)) {
            this.successIcon.setVisibility(0);
        } else {
            this.successIcon.setVisibility(8);
        }
    }

    /* renamed from: d, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* renamed from: e, reason: from getter */
    public final TroopTeacherFileVM getViewModel() {
        return this.viewModel;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        n nVar = this.troopFileInfo;
        int i3 = nVar.f294930p;
        boolean z16 = nVar.B;
        long parseLong = Long.parseLong(this.viewModel.getTroopUin());
        String str = this.troopFileInfo.f294917c;
        Intrinsics.checkNotNullExpressionValue(str, "troopFileInfo.str_file_name");
        if (bb.o(qQAppInterface, i3, z16, parseLong, str, this.troopFileInfo.f294918d, 4)) {
            h();
        } else {
            g();
        }
    }

    public final void p(n troopFileInfo, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(troopFileInfo, "troopFileInfo");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.troopFileInfo = troopFileInfo;
        if (payloads.isEmpty()) {
            c();
            return;
        }
        Object obj = payloads.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
        for (Object obj2 : (List) obj) {
            if (obj2 == TroopTeacherFileAdapter.ChangePayload.CHANGE_PAYLOAD_FILE_COVER) {
                m();
            }
            if (obj2 == TroopTeacherFileAdapter.ChangePayload.CHANGE_PAYLOAD_FILE_DOWNLOAD_STATUS) {
                o();
                k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopTeacherFileItemView(TroopTeacherFileVM viewModel, Activity activity, Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewModel = viewModel;
        this.activity = activity;
        this.troopFileInfo = new n();
        this.mFileViewStatusArray = new SparseIntArray();
        LayoutInflater.from(context).inflate(R.layout.g1t, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f167030k25);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.troopfile_fileIcon)");
        this.coverImageView = (AsyncImageView) findViewById;
        View findViewById2 = findViewById(R.id.f167026k21);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.troopfile_action_btn)");
        this.downloadStatusView = (CircleFileStateView) findViewById2;
        View findViewById3 = findViewById(R.id.k26);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.troopfile_fileName)");
        this.fileNameTextView = (EllipsizingTextView) findViewById3;
        View findViewById4 = findViewById(R.id.f167029k24);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.troopfile_desc_icon)");
        this.successIcon = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f167028k23);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.troopfile_desc)");
        this.detailTextView = (TextView) findViewById5;
        this.mFileViewStatusArray.put(0, 1);
        this.mFileViewStatusArray.put(1, 1);
        this.mFileViewStatusArray.put(2, 3);
        this.mFileViewStatusArray.put(3, 3);
        this.mFileViewStatusArray.put(6, -1);
        this.mFileViewStatusArray.put(8, 1);
        this.mFileViewStatusArray.put(9, 2);
        this.mFileViewStatusArray.put(10, 2);
        this.mFileViewStatusArray.put(11, -1);
        this.mFileViewStatusArray.put(7, -1);
        long parseLong = Long.parseLong(viewModel.getTroopUin());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.mItemOperation = new TroopFileItemOperation(parseLong, peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null, activity);
        setOnClickListener(this);
    }

    private final void f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("TRANS_PARAM_NT_MSGID", this.troopFileInfo.G);
        bundle.putLong("TRANS_PARAM_NT_ELEMENTID", this.troopFileInfo.H);
        bundle.putLong("TRANS_PARAM_UPLOAD_TIME", this.troopFileInfo.f());
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.parseLong(this.viewModel.getTroopUin()));
        n nVar = this.troopFileInfo;
        switch (nVar.f294930p) {
            case 0:
            case 1:
                O.D0(nVar.f294915a);
                this.downloadStatusView.setState(3);
                return;
            case 2:
                this.mItemOperation.z(nVar.f294915a, null);
                return;
            case 3:
                this.mItemOperation.y(nVar);
                return;
            case 4:
            case 5:
            default:
                return;
            case 6:
            case 11:
                t r16 = this.mItemOperation.r(nVar);
                int q16 = this.mItemOperation.q(this.troopFileInfo);
                QFileUtils.n(qQAppInterface, getContext(), null, null, Long.parseLong(this.viewModel.getTroopUin()), r16, String.valueOf(this.troopFileInfo.f294920f), this.troopFileInfo.f294923i, q16, QFileUtils.X(q16, 4), null, false, false);
                return;
            case 7:
                this.mItemOperation.C(nVar.f294916b, nVar.f294917c, nVar.f294918d, nVar.f294919e, bundle, null);
                this.downloadStatusView.setState(2);
                return;
            case 8:
                O.C0(nVar.f294915a);
                this.downloadStatusView.setState(2);
                return;
            case 9:
                this.mItemOperation.w(nVar.f294915a, bundle, null);
                return;
            case 10:
                this.mItemOperation.x(nVar, bundle);
                this.downloadStatusView.setState(2);
                return;
            case 12:
                this.mItemOperation.B(nVar, getContext().getString(R.string.evm), getContext().getString(R.string.evn));
                this.downloadStatusView.setState(2);
                return;
            case 13:
                this.mItemOperation.m(nVar);
                this.downloadStatusView.setState(1);
                return;
        }
    }

    private final void g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        n nVar = this.troopFileInfo;
        switch (nVar.f294930p) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                t r16 = this.mItemOperation.r(nVar);
                Intrinsics.checkNotNullExpressionValue(r16, "mItemOperation.getFileSt\u2026ileBrowser(troopFileInfo)");
                int q16 = this.mItemOperation.q(this.troopFileInfo);
                QFileUtils.n(qQAppInterface, getContext(), null, null, Long.parseLong(this.viewModel.getTroopUin()), r16, String.valueOf(this.troopFileInfo.f294920f), this.troopFileInfo.f294923i, q16, QFileUtils.X(q16, 4), QFileUtils.b0(this.coverImageView, this.troopFileInfo.f294917c), false, false);
                return;
            case 4:
            case 5:
            default:
                return;
            case 12:
                this.mItemOperation.B(nVar, getContext().getString(R.string.evm), getContext().getString(R.string.evn));
                return;
            case 13:
                this.mItemOperation.m(nVar);
                return;
        }
    }

    private final void i(SpannableString spannableString, String detailInfo, String clickableText) {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) detailInfo, clickableText, 0, false, 6, (Object) null);
        spannableString.setSpan(new a(), indexOf$default, clickableText.length() + indexOf$default, 33);
    }
}
