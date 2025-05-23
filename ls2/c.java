package ls2;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.s;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#J \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006$"}, d2 = {"Lls2/c;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/data/s;", "itemData", "Lls2/a;", "interact", "", "c", "Lcom/tencent/mobileqq/filemanager/widget/AsyncImageView;", "fileIcon", "Lcom/tencent/mobileqq/troop/data/n;", "fileInfo", "d", "Landroid/view/View;", "a", "Landroid/view/View;", "convertView", "Landroid/widget/RelativeLayout;", "b", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", TtmlNode.TAG_LAYOUT, "Lcom/tencent/mobileqq/filemanager/widget/AsyncImageView;", "()Lcom/tencent/mobileqq/filemanager/widget/AsyncImageView;", "fileIconIv", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "fileNameTv", "e", "fileDescTv", "Landroid/view/View$OnClickListener;", "itemClickListener", "<init>", "(Landroid/view/View;Landroid/view/View$OnClickListener;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View convertView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout layout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AsyncImageView fileIconIv;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView fileNameTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView fileDescTv;

    public c(View convertView, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(convertView, "convertView");
        this.convertView = convertView;
        View findViewById = convertView.findViewById(R.id.f167025k20);
        Intrinsics.checkNotNullExpressionValue(findViewById, "convertView.findViewById(R.id.troopfile_Item)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.layout = relativeLayout;
        relativeLayout.setOnClickListener(onClickListener);
        View findViewById2 = convertView.findViewById(R.id.f167030k25);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "convertView.findViewById(R.id.troopfile_fileIcon)");
        this.fileIconIv = (AsyncImageView) findViewById2;
        View findViewById3 = convertView.findViewById(R.id.k26);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "convertView.findViewById(R.id.troopfile_fileName)");
        this.fileNameTv = (TextView) findViewById3;
        View findViewById4 = convertView.findViewById(R.id.f167028k23);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "convertView.findViewById(R.id.troopfile_desc)");
        this.fileDescTv = (TextView) findViewById4;
    }

    /* renamed from: a, reason: from getter */
    public final AsyncImageView getFileIconIv() {
        return this.fileIconIv;
    }

    /* renamed from: b, reason: from getter */
    public final RelativeLayout getLayout() {
        return this.layout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(Context context, s itemData, a interact) {
        boolean z16;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        Intrinsics.checkNotNullParameter(interact, "interact");
        this.layout.setTag(R.id.giu, itemData);
        n nVar = itemData.f294966i;
        if (nVar != null) {
            this.fileNameTv.setText(nVar.f294917c);
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(String.valueOf(itemData.f294958a), String.valueOf(itemData.f294960c), context instanceof LifecycleOwner ? (LifecycleOwner) context : null, "");
            if (troopMemberInfoSync != null) {
                String str3 = troopMemberInfoSync.troopnick;
                long j3 = itemData.f294960c;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j3);
                if (ac.v0(str3, sb5.toString())) {
                    z16 = true;
                    String str4 = nVar.E;
                    Intrinsics.checkNotNullExpressionValue(str4, "fileInfo.mUpLoadTimeStr");
                    if (!z16) {
                        Intrinsics.checkNotNull(troopMemberInfoSync);
                        str = troopMemberInfoSync.troopnick;
                        str2 = "tmi!!.troopnick";
                    } else {
                        str = itemData.f294961d;
                        str2 = "itemData.uploaderNickName";
                    }
                    Intrinsics.checkNotNullExpressionValue(str, str2);
                    String e16 = nVar.e();
                    Intrinsics.checkNotNullExpressionValue(e16, "fileInfo.fileSizeDesc");
                    QFileUtils.n0(context, this.fileDescTv, str4, str, e16, "", "", false, null);
                    if (nVar.f294937w == null) {
                        String str5 = nVar.f294916b;
                        Intrinsics.checkNotNullExpressionValue(str5, "fileInfo.mFileId");
                        String str6 = nVar.f294917c;
                        Intrinsics.checkNotNullExpressionValue(str6, "fileInfo.str_file_name");
                        interact.S4(str5, str6, nVar.f294919e, 128);
                    }
                    d(this.fileIconIv, nVar);
                }
            }
            z16 = false;
            String str42 = nVar.E;
            Intrinsics.checkNotNullExpressionValue(str42, "fileInfo.mUpLoadTimeStr");
            if (!z16) {
            }
            Intrinsics.checkNotNullExpressionValue(str, str2);
            String e162 = nVar.e();
            Intrinsics.checkNotNullExpressionValue(e162, "fileInfo.fileSizeDesc");
            QFileUtils.n0(context, this.fileDescTv, str42, str, e162, "", "", false, null);
            if (nVar.f294937w == null) {
            }
            d(this.fileIconIv, nVar);
        }
    }

    public final void d(AsyncImageView fileIcon, n fileInfo) {
        Intrinsics.checkNotNullParameter(fileIcon, "fileIcon");
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        if (FileUtils.fileExistsAndNotEmpty(fileInfo.f294937w)) {
            FileManagerUtil.setFileIcon(fileIcon, fileInfo.f294937w, FileManagerUtil.getFileType(fileInfo.f294917c));
        } else {
            fileIcon.setDefaultImage(FileManagerUtil.getFileIconResId(fileInfo.f294917c));
        }
    }
}
