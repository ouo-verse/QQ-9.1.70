package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.adapter.api.IPublicAccountPluginApi;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/PublicAccountPluginApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IPublicAccountPluginApi;", "Lcom/tencent/mobileqq/graytip/UniteEntity;", "uniteEntity", "Lcom/tencent/qqnt/aio/adapter/api/d;", "handleCommonGlobalDialog", "", "runTimePublicAccountPluginSwitch", "", "content", "parseXMLContent", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "httpMqqJump", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PublicAccountPluginApiImpl implements IPublicAccountPluginApi {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/PublicAccountPluginApiImpl$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f348583d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f348584e;

        a(String str, String str2) {
            this.f348583d = str;
            this.f348584e = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setUnderlineText(false);
            if (!TextUtils.isEmpty(this.f348583d)) {
                ds5.setColor(Color.parseColor(this.f348583d));
            }
            if (TextUtils.isEmpty(this.f348584e)) {
                return;
            }
            ds5.setTextSize(ViewUtils.spToPx(NumberUtil.stringToFloat(this.f348584e)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    @Override // com.tencent.qqnt.aio.adapter.api.IPublicAccountPluginApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void httpMqqJump(String jumpUrl, BaseQQAppInterface app, Context context) {
        boolean startsWith$default;
        boolean z16;
        boolean startsWith$default2;
        com.tencent.mobileqq.utils.ax c16;
        boolean startsWith$default3;
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        if (TextUtils.isEmpty(jumpUrl)) {
            return;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = jumpUrl.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "http://", false, 2, null);
        if (!startsWith$default) {
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
            String lowerCase2 = jumpUrl.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(lowerCase2, "https://", false, 2, null);
            if (!startsWith$default3) {
                z16 = false;
                Locale locale3 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale3, "getDefault()");
                String lowerCase3 = jumpUrl.toLowerCase(locale3);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(lowerCase3, "mqqapi://", false, 2, null);
                if (!z16) {
                    Intent intent = new Intent();
                    intent.putExtra("url", jumpUrl);
                    RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
                    return;
                } else {
                    if (!startsWith$default2 || (c16 = bi.c(app, context, jumpUrl)) == null) {
                        return;
                    }
                    c16.z();
                    c16.b();
                    return;
                }
            }
        }
        z16 = true;
        Locale locale32 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale32, "getDefault()");
        String lowerCase32 = jumpUrl.toLowerCase(locale32);
        Intrinsics.checkNotNullExpressionValue(lowerCase32, "this as java.lang.String).toLowerCase(locale)");
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(lowerCase32, "mqqapi://", false, 2, null);
        if (!z16) {
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPublicAccountPluginApi
    public com.tencent.qqnt.aio.adapter.api.d parseXMLContent(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        UniteEntity uniteEntity = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).parseXMLContent(content);
        Intrinsics.checkNotNullExpressionValue(uniteEntity, "uniteEntity");
        return handleCommonGlobalDialog(uniteEntity);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPublicAccountPluginApi
    public boolean runTimePublicAccountPluginSwitch() {
        return ((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch();
    }

    private final com.tencent.qqnt.aio.adapter.api.d handleCommonGlobalDialog(UniteEntity uniteEntity) {
        ArrayList<UniteEntity.Note> subNotes;
        if (uniteEntity == null) {
            return null;
        }
        UniteEntity.Note rootNote = uniteEntity.getRootNote();
        if (rootNote.getNoteType() != 6 || (subNotes = rootNote.getSubNotes()) == null || subNotes.size() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = "1";
        for (UniteEntity.Note note : subNotes) {
            HashMap<Integer, Object> fields = note.getFields();
            ArrayList<UniteEntity.Note> subNotes2 = note.getSubNotes();
            int i3 = 2;
            if (note.getNoteType() == 7) {
                String str7 = (String) fields.get(2);
                if (!TextUtils.isEmpty(str7)) {
                    str = str7 == null ? "" : str7;
                }
            } else {
                int i16 = 4;
                int i17 = 0;
                if (note.getNoteType() == 8) {
                    if (subNotes2 != null && !subNotes2.isEmpty()) {
                        for (UniteEntity.Note note2 : subNotes2) {
                            HashMap<Integer, Object> fields2 = note2.getFields();
                            if (fields2 != null) {
                                if (note2.getNoteType() == i3) {
                                    String str8 = (String) fields2.get(Integer.valueOf(i3));
                                    if (!TextUtils.isEmpty(str8)) {
                                        SpannableString spannableString = new SpannableString(str8);
                                        spannableStringBuilder.append((CharSequence) spannableString);
                                        str2 = str2 + ((Object) spannableString);
                                    }
                                } else if (note2.getNoteType() == 3) {
                                    String str9 = (String) fields2.get(Integer.valueOf(i3));
                                    if (!TextUtils.isEmpty(str9)) {
                                        String str10 = (String) fields2.get(3);
                                        String str11 = (String) fields2.get(5);
                                        SpannableString spannableString2 = new SpannableString(str9);
                                        a aVar = new a(str11, str10);
                                        Intrinsics.checkNotNull(str9);
                                        spannableString2.setSpan(aVar, 0, str9.length(), 33);
                                        spannableStringBuilder.append((CharSequence) spannableString2);
                                        str2 = str2 + ((Object) spannableString2);
                                    }
                                }
                            }
                            i16 = 4;
                            i3 = 2;
                        }
                    }
                } else if (note.getNoteType() == 9 && subNotes2 != null && !subNotes2.isEmpty()) {
                    for (UniteEntity.Note note3 : subNotes2) {
                        if (note3.getNoteType() == 10) {
                            HashMap<Integer, Object> fields3 = note3.getFields();
                            String str12 = (String) fields3.get(2);
                            String str13 = (String) fields3.get(4);
                            if (i17 == 0) {
                                if (str12 != null) {
                                    str5 = str12;
                                }
                                if (str13 != null) {
                                    str6 = str13;
                                }
                            } else if (i17 == 1) {
                                if (str12 != null) {
                                    str4 = str12;
                                }
                                if (str13 != null) {
                                    str3 = str13;
                                }
                            }
                            i17++;
                        }
                    }
                }
            }
        }
        return new com.tencent.qqnt.aio.adapter.api.d(str, str2, str3, str6, str4, str5);
    }
}
