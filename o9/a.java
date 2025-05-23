package o9;

import android.widget.ImageView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R2\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010(\u001a\u0004\b\u0012\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lo9/a;", "", "", "d", "I", "e", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "curPos", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "c", "()Landroid/widget/ImageView;", "l", "(Landroid/widget/ImageView;)V", "clickView", "", "f", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "albumId", h.F, "b", "k", AEEditorConstants.ALBUMNAME, "Ljava/util/ArrayList;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "g", "()Ljava/util/ArrayList;", "o", "(Ljava/util/ArrayList;)V", "mediaInfoList", "", "Z", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "disallowInteract", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int curPos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView clickView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String albumId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String albumName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ArrayList<RFWLayerItemMediaInfo> mediaInfoList = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean disallowInteract;

    /* renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: c, reason: from getter */
    public final ImageView getClickView() {
        return this.clickView;
    }

    /* renamed from: e, reason: from getter */
    public final int getCurPos() {
        return this.curPos;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getDisallowInteract() {
        return this.disallowInteract;
    }

    public final ArrayList<RFWLayerItemMediaInfo> g() {
        return this.mediaInfoList;
    }

    public final void j(String str) {
        this.albumId = str;
    }

    public final void k(String str) {
        this.albumName = str;
    }

    public final void l(ImageView imageView) {
        this.clickView = imageView;
    }

    public final void m(int i3) {
        this.curPos = i3;
    }

    public final void n(boolean z16) {
        this.disallowInteract = z16;
    }

    public final void o(ArrayList<RFWLayerItemMediaInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mediaInfoList = arrayList;
    }
}
