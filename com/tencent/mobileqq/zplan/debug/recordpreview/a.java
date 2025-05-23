package com.tencent.mobileqq.zplan.debug.recordpreview;

import android.content.Context;
import android.text.Editable;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.zplan.record.model.Source;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b)\u0010*J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0004J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/recordpreview/a;", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "initState", "Landroid/util/Size;", "e", "", "a", "b", "", "Lcom/tencent/zplan/record/model/Source;", "d", "", "c", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "settingUseFilamentEngine", "Landroid/widget/RadioGroup;", "f", "Landroid/widget/RadioGroup;", "settingBodyType", "Landroid/widget/EditText;", h.F, "Landroid/widget/EditText;", "settingViewPortSize", "i", "settingCameraParams", "Landroid/widget/CheckBox;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/CheckBox;", "settingRecordSourceLocalCache", BdhLogUtil.LogTag.Tag_Conn, "settingRecordSourceCloudCache", "D", "settingRecordSourceLocalRecord", "<init>", "(Landroid/content/Context;)V", "E", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends com.tencent.mobileqq.widget.qus.e {

    /* renamed from: C, reason: from kotlin metadata */
    private CheckBox settingRecordSourceCloudCache;

    /* renamed from: D, reason: from kotlin metadata */
    private CheckBox settingRecordSourceLocalRecord;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem settingUseFilamentEngine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RadioGroup settingBodyType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private EditText settingViewPortSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EditText settingCameraParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CheckBox settingRecordSourceLocalCache;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final boolean a() {
        FormSwitchItem formSwitchItem = this.settingUseFilamentEngine;
        if (formSwitchItem != null) {
            return formSwitchItem.isChecked();
        }
        return true;
    }

    public final int b() {
        RadioGroup radioGroup = this.settingBodyType;
        if (radioGroup == null) {
            return -1;
        }
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId != R.id.qg_) {
            return checkedRadioButtonId != R.id.qgb ? -1 : 1;
        }
        return 2;
    }

    public final String c() {
        Editable text;
        EditText editText = this.settingCameraParams;
        if (editText == null || (text = editText.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    @Override // com.tencent.mobileqq.widget.qus.d
    public View createContentView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.dbd, (ViewGroup) null);
        this.settingUseFilamentEngine = (FormSwitchItem) inflate.findViewById(R.id.qgj);
        this.settingBodyType = (RadioGroup) inflate.findViewById(R.id.qga);
        EditText editText = (EditText) inflate.findViewById(R.id.qgk);
        this.settingViewPortSize = editText;
        if (editText != null) {
            editText.setHint("600*600");
        }
        this.settingCameraParams = (EditText) inflate.findViewById(R.id.qgd);
        this.settingRecordSourceLocalCache = (CheckBox) inflate.findViewById(R.id.qgh);
        this.settingRecordSourceCloudCache = (CheckBox) inflate.findViewById(R.id.qgf);
        this.settingRecordSourceLocalRecord = (CheckBox) inflate.findViewById(R.id.qgi);
        return inflate;
    }

    public final List<Source> d() {
        ArrayList arrayList = new ArrayList();
        CheckBox checkBox = this.settingRecordSourceLocalCache;
        if (checkBox != null && checkBox.isChecked()) {
            arrayList.add(Source.LOCAL_CACHE);
        }
        CheckBox checkBox2 = this.settingRecordSourceCloudCache;
        if (checkBox2 != null && checkBox2.isChecked()) {
            arrayList.add(Source.CLOUD_CACHE);
        }
        CheckBox checkBox3 = this.settingRecordSourceLocalRecord;
        if (checkBox3 != null && checkBox3.isChecked()) {
            arrayList.add(Source.LOCAL_RECORD);
        }
        return arrayList;
    }

    public final Size e() {
        List split$default;
        int i3;
        EditText editText = this.settingViewPortSize;
        split$default = StringsKt__StringsKt.split$default((CharSequence) String.valueOf(editText != null ? editText.getText() : null), new String[]{"*"}, false, 0, 6, (Object) null);
        int i16 = 600;
        if (split$default != null && split$default.size() == 2) {
            try {
                i3 = Integer.parseInt((String) split$default.get(0));
            } catch (NumberFormatException unused) {
                i3 = 600;
            }
            try {
                i16 = Integer.parseInt((String) split$default.get(1));
            } catch (NumberFormatException unused2) {
            }
            return new Size(i3, i16);
        }
        return new Size(600, 600);
    }

    @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
    public int initState() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
    public int showMode() {
        return 1;
    }
}
