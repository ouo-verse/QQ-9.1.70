package bm;

import android.text.Editable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.QQTextBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lbm/a;", "Lql/a;", "", "getLogTag", "", "M1", "Landroid/text/Editable;", "editable", "shuoshuoContent", "", "Q1", "O1", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_plaintextContentLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "plaintextContentLiveData", "D", "_shuoshuoContentLiveData", "E", "getShuoshuoContentLiveData", "shuoshuoContentLiveData", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends ql.a<String> {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<String> plaintextContentLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<String> _shuoshuoContentLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<String> shuoshuoContentLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _plaintextContentLiveData;

    public a() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this._plaintextContentLiveData = mutableLiveData;
        this.plaintextContentLiveData = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>("");
        this._shuoshuoContentLiveData = mutableLiveData2;
        this.shuoshuoContentLiveData = mutableLiveData2;
    }

    @Override // ql.a
    public boolean M1() {
        CharSequence trim;
        trim = StringsKt__StringsKt.trim((CharSequence) O1());
        return trim.toString().length() > 0;
    }

    public final String O1() {
        String value = this.plaintextContentLiveData.getValue();
        return value == null ? "" : value;
    }

    public final LiveData<String> P1() {
        return this.plaintextContentLiveData;
    }

    public final void Q1(Editable editable, String shuoshuoContent) {
        String str;
        Intrinsics.checkNotNullParameter(shuoshuoContent, "shuoshuoContent");
        MutableLiveData<String> mutableLiveData = this._plaintextContentLiveData;
        if (editable instanceof QQTextBuilder) {
            str = ((QQTextBuilder) editable).toPlainText();
        } else if (editable == null || (str = editable.toString()) == null) {
            str = "";
        }
        mutableLiveData.setValue(str);
        this._shuoshuoContentLiveData.setValue(shuoshuoContent);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneTextContentViewModel";
    }
}
