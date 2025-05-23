package com.tencent.biz.qqcircle.immersive;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageContentLandscapePart;
import com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageContentPart;
import com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageInputPart;
import com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageTitlePart;
import com.tencent.biz.qqcircle.immersive.part.commentimage.af;
import com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/QFSCommentImageFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "", "getLogTag", "getPageId", "getDaTongPageId", "", "E", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentImageFragment extends QFSBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isLandscape;

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QFSPersonalPanelPart qFSPersonalPanelPart = new QFSPersonalPanelPart();
        qFSPersonalPanelPart.ca(4);
        arrayList.add(qFSPersonalPanelPart);
        arrayList.add(new QFSCommentImageTitlePart());
        arrayList.add(new QFSCommentImageInputPart());
        if (this.isLandscape) {
            arrayList.add(new QFSCommentImageContentLandscapePart());
        } else {
            arrayList.add(new QFSCommentImageContentPart());
        }
        arrayList.add(new QCircleRichMediaDownLoadPart());
        arrayList.add(new af(QCirclePluginUtil.getQCircleInitBean(getActivity()), this.isLandscape));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g9g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_LARGE_PIC_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentImageFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 57;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Integer num;
        boolean z16;
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            num = Integer.valueOf(intent.getIntExtra("orientation_type_flag", -1));
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isLandscape = z16;
        QLog.d("QFSCommentImageFragment", 1, "[onCreate] isLandscape=" + z16);
    }
}
