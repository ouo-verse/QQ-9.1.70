package com.tencent.kuikly.core.render.android.expand.module;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.scheduler.KRSubThreadScheduler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import d01.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JN\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bj\u0004\u0018\u0001`\u000fH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017JW\u0010\u001c\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u001128\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00060\u0019H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002JI\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020#2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bj\u0004\u0018\u0001`\u000fH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRSQLiteModule;", "Li01/e;", "", "params", "", "w", "", "p", "t", HippyTKDListViewAdapter.X, "o", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "", "v", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "Landroid/database/Cursor;", "cursor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/database/Cursor;)[Ljava/lang/Object;", "queryArgs", "Lkotlin/Function2;", "", "sync", "u", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Landroid/database/sqlite/SQLiteDatabase;", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, TtmlNode.ATTR_TTS_ORIGIN, "l", "", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/kuikly/core/render/android/expand/module/p;", "d", "Lcom/tencent/kuikly/core/render/android/expand/module/p;", "sqliteOpenHelper", "<init>", "()V", "e", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRSQLiteModule extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private p sqliteOpenHelper;

    /* JADX INFO: Access modifiers changed from: private */
    public final int l(int origin) {
        if (origin != 1) {
            if (origin == 2) {
                return 2;
            }
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] m(Cursor cursor) {
        List list;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = cursor;
        try {
            Cursor cursor3 = cursor2;
            arrayList.add(new byte[0]);
            int columnCount = cursor3.getColumnCount();
            arrayList.add(Integer.valueOf(columnCount));
            String[] columnNames = cursor3.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "columnNames");
            list = ArraysKt___ArraysKt.toList(columnNames);
            arrayList.addAll(list);
            arrayList.add(Integer.valueOf(cursor.getCount()));
            while (cursor.moveToNext()) {
                for (int i3 = 0; i3 < columnCount; i3++) {
                    int type = cursor.getType(i3);
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                                if (type == 4) {
                                    byte[] blob = cursor.getBlob(i3);
                                    Intrinsics.checkNotNullExpressionValue(blob, "cursor.getBlob(i)");
                                    arrayList.add(blob);
                                }
                            } else {
                                String string = cursor.getString(i3);
                                if (string == null) {
                                    string = "";
                                }
                                arrayList.add(string);
                            }
                        } else {
                            arrayList.add(Double.valueOf(cursor.getDouble(i3)));
                        }
                    } else {
                        arrayList.add(Long.valueOf(cursor.getLong(i3)));
                    }
                }
            }
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                CloseableKt.closeFinally(cursor2, null);
                return array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } finally {
        }
    }

    private final void o(Object params) {
        if (params != null) {
            final Object[] objArr = (Object[]) params;
            boolean z16 = false;
            Object obj = objArr[0];
            if (obj != null) {
                if (((Integer) obj).intValue() == 1) {
                    z16 = true;
                }
                final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$delete$task$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SQLiteDatabase r16;
                        String[] strArr;
                        r16 = KRSQLiteModule.this.r();
                        if (r16 == null) {
                            return;
                        }
                        r16.beginTransaction();
                        int i3 = 1;
                        while (true) {
                            try {
                                Object[] objArr2 = objArr;
                                if (i3 < objArr2.length) {
                                    int i16 = i3 + 1;
                                    Object obj2 = objArr2[i3];
                                    if (obj2 != null) {
                                        String str = (String) obj2;
                                        int i17 = i16 + 1;
                                        Object obj3 = objArr2[i16];
                                        if (obj3 != null) {
                                            String str2 = (String) obj3;
                                            int i18 = i17 + 1;
                                            Object obj4 = objArr2[i17];
                                            if (obj4 != null) {
                                                int intValue = ((Integer) obj4).intValue();
                                                if (intValue > 0) {
                                                    strArr = new String[intValue];
                                                    int i19 = 0;
                                                    while (i19 < intValue) {
                                                        strArr[i19] = objArr[i18].toString();
                                                        i19++;
                                                        i18++;
                                                    }
                                                } else {
                                                    strArr = null;
                                                }
                                                r16.delete(str, str2, strArr);
                                                i3 = i18;
                                            } else {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                            }
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } else {
                                    r16.setTransactionSuccessful();
                                    break;
                                }
                            } finally {
                                try {
                                    return;
                                } finally {
                                }
                            }
                        }
                    }
                };
                if (z16) {
                    function0.invoke();
                    return;
                } else {
                    KRSubThreadScheduler.f118174c.e(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$delete$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function0.this.invoke();
                        }
                    });
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
    }

    private final void p(Object params) {
        final List list;
        if (params != null) {
            list = ArraysKt___ArraysKt.toList((Object[]) params);
            boolean z16 = false;
            Object obj = list.get(0);
            if (obj != null) {
                if (((Integer) obj).intValue() == 1) {
                    z16 = true;
                }
                final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$executeSql$task$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SQLiteDatabase r16;
                        r16 = KRSQLiteModule.this.r();
                        if (r16 != null) {
                            r16.beginTransaction();
                            int i3 = 1;
                            while (i3 < list.size()) {
                                try {
                                    int i16 = i3 + 1;
                                    Object obj2 = list.get(i3);
                                    if (obj2 != null) {
                                        String str = (String) obj2;
                                        int i17 = i16 + 1;
                                        Object obj3 = list.get(i16);
                                        if (obj3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                        }
                                        int intValue = ((Integer) obj3).intValue();
                                        if (intValue == 0) {
                                            r16.execSQL(str);
                                        } else {
                                            Object[] objArr = new Object[intValue];
                                            int i18 = 0;
                                            while (i18 < intValue) {
                                                objArr[i18] = list.get(i17);
                                                i18++;
                                                i17++;
                                            }
                                            r16.execSQL(str, objArr);
                                        }
                                        i3 = i17;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                            r16.setTransactionSuccessful();
                        }
                    }
                };
                if (z16) {
                    function0.invoke();
                    return;
                } else {
                    KRSubThreadScheduler.f118174c.e(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$executeSql$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function0.this.invoke();
                        }
                    });
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SQLiteDatabase q() {
        p pVar = this.sqliteOpenHelper;
        if (pVar != null) {
            return pVar.getReadableDatabase();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SQLiteDatabase r() {
        p pVar = this.sqliteOpenHelper;
        if (pVar != null) {
            return pVar.getWritableDatabase();
        }
        return null;
    }

    private final void t(Object params) {
        if (params != null) {
            final Object[] objArr = (Object[]) params;
            boolean z16 = false;
            Object obj = objArr[0];
            if (obj != null) {
                if (((Integer) obj).intValue() == 1) {
                    z16 = true;
                }
                final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$insert$task$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SQLiteDatabase r16;
                        int l3;
                        r16 = KRSQLiteModule.this.r();
                        if (r16 != null) {
                            try {
                                r16.beginTransaction();
                                int i3 = 1;
                                while (true) {
                                    Object[] objArr2 = objArr;
                                    if (i3 < objArr2.length) {
                                        int i16 = i3 + 1;
                                        Object obj2 = objArr2[i3];
                                        if (obj2 != null) {
                                            String str = (String) obj2;
                                            KRSQLiteModule kRSQLiteModule = KRSQLiteModule.this;
                                            int i17 = i16 + 1;
                                            Object obj3 = objArr2[i16];
                                            if (obj3 != null) {
                                                l3 = kRSQLiteModule.l(((Integer) obj3).intValue());
                                                int i18 = i17 + 1;
                                                Object obj4 = objArr[i17];
                                                if (obj4 != null) {
                                                    int intValue = ((Integer) obj4).intValue();
                                                    ContentValues contentValues = new ContentValues();
                                                    int i19 = 0;
                                                    while (i19 < intValue) {
                                                        Object[] objArr3 = objArr;
                                                        int i26 = i18 + 1;
                                                        Object obj5 = objArr3[i18];
                                                        if (obj5 != null) {
                                                            String str2 = (String) obj5;
                                                            int i27 = i26 + 1;
                                                            Object obj6 = objArr3[i26];
                                                            if (obj6 instanceof String) {
                                                                contentValues.put(str2, (String) obj6);
                                                            } else if (obj6 instanceof Integer) {
                                                                contentValues.put(str2, (Integer) obj6);
                                                            } else if (obj6 instanceof Long) {
                                                                contentValues.put(str2, (Long) obj6);
                                                            } else if (obj6 instanceof Double) {
                                                                contentValues.put(str2, (Double) obj6);
                                                            } else if (obj6 instanceof Float) {
                                                                contentValues.put(str2, (Float) obj6);
                                                            } else if (obj6 instanceof Boolean) {
                                                                contentValues.put(str2, (Boolean) obj6);
                                                            } else if (obj6 instanceof byte[]) {
                                                                contentValues.put(str2, (byte[]) obj6);
                                                            }
                                                            i19++;
                                                            i18 = i27;
                                                        } else {
                                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                        }
                                                    }
                                                    if (contentValues.size() != 0) {
                                                        r16.insertWithOnConflict(str, null, contentValues, l3);
                                                    }
                                                    i3 = i18;
                                                } else {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                                }
                                            } else {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                            }
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                    } else {
                                        r16.setTransactionSuccessful();
                                        break;
                                    }
                                }
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                        if (r16 == null) {
                        }
                    }
                };
                if (z16) {
                    function0.invoke();
                    return;
                } else {
                    KRSubThreadScheduler.f118174c.e(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$insert$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function0.this.invoke();
                        }
                    });
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, java.lang.String[]] */
    private final void u(Object[] queryArgs, final Function2<? super Boolean, ? super Cursor, Unit> callback) {
        boolean z16;
        int i3 = 0;
        Object obj = queryArgs[0];
        if (obj != null) {
            if (((Integer) obj).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            Object obj2 = queryArgs[1];
            if (obj2 != null) {
                final String str = (String) obj2;
                Object obj3 = queryArgs[2];
                if (obj3 != null) {
                    int intValue = ((Integer) obj3).intValue();
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = null;
                    int i16 = 3;
                    if (intValue > 0) {
                        objectRef.element = new String[intValue];
                        int i17 = 0;
                        while (i17 < intValue) {
                            String[] strArr = (String[]) objectRef.element;
                            int i18 = i16 + 1;
                            Object obj4 = queryArgs[i16];
                            if (obj4 != null) {
                                strArr[i17] = (String) obj4;
                                i17++;
                                i16 = i18;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                    }
                    int i19 = i16 + 1;
                    Object obj5 = queryArgs[i16];
                    if (obj5 != null) {
                        final String str2 = (String) obj5;
                        int i26 = i19 + 1;
                        Object obj6 = queryArgs[i19];
                        if (obj6 != null) {
                            int intValue2 = ((Integer) obj6).intValue();
                            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                            objectRef2.element = null;
                            if (intValue2 > 0) {
                                objectRef2.element = new String[intValue2];
                                while (i3 < intValue2) {
                                    ((String[]) objectRef2.element)[i3] = queryArgs[i26].toString();
                                    i3++;
                                    i26++;
                                }
                            }
                            int i27 = i26 + 1;
                            Object obj7 = queryArgs[i26];
                            if (obj7 != null) {
                                final String str3 = (String) obj7;
                                int i28 = i27 + 1;
                                Object obj8 = queryArgs[i27];
                                if (obj8 != null) {
                                    final String str4 = (String) obj8;
                                    int i29 = i28 + 1;
                                    Object obj9 = queryArgs[i28];
                                    if (obj9 != null) {
                                        final String str5 = (String) obj9;
                                        Object obj10 = queryArgs[i29];
                                        if (obj10 != null) {
                                            final String str6 = (String) obj10;
                                            final Function0<Cursor> function0 = new Function0<Cursor>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$select$selectBlock$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                @Override // kotlin.jvm.functions.Function0
                                                @Nullable
                                                public final Cursor invoke() {
                                                    SQLiteDatabase q16;
                                                    q16 = KRSQLiteModule.this.q();
                                                    if (q16 == null) {
                                                        return null;
                                                    }
                                                    try {
                                                        return q16.query(str, (String[]) objectRef.element, str2, (String[]) objectRef2.element, str3, str4, str5, str6);
                                                    } catch (Throwable th5) {
                                                        w.f392617a.b("KRSQLiteModule", "query error: " + th5);
                                                        return null;
                                                    }
                                                }
                                            };
                                            if (z16) {
                                                callback.invoke(Boolean.TRUE, function0.invoke());
                                                return;
                                            } else {
                                                KRSubThreadScheduler.f118174c.e(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$select$2
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                                        invoke2();
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2() {
                                                        Function2.this.invoke(Boolean.FALSE, function0.invoke());
                                                    }
                                                });
                                                return;
                                            }
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object[] v(Object params, final Function1<Object, Unit> callback) {
        if (params != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            u((Object[]) params, new Function2<Boolean, Cursor, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$select$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Cursor cursor) {
                    invoke(bool.booleanValue(), cursor);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(boolean z16, @Nullable Cursor cursor) {
                    T t16;
                    Object[] m3;
                    if (cursor != null) {
                        m3 = KRSQLiteModule.this.m(cursor);
                        t16 = m3;
                    } else {
                        t16 = 0;
                    }
                    if (z16) {
                        objectRef.element = t16;
                        return;
                    }
                    Function1 function1 = callback;
                    if (function1 != null) {
                    }
                }
            });
            return (Object[]) objectRef.element;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
    }

    private final int w(Object params) {
        Context context = getContext();
        if (context != null) {
            if (params != null) {
                Object[] objArr = (Object[]) params;
                Object obj = objArr[0];
                if (obj != null) {
                    String str = (String) obj;
                    Object obj2 = objArr[1];
                    if (obj2 != null) {
                        int intValue = ((Integer) obj2).intValue();
                        final Ref.IntRef intRef = new Ref.IntRef();
                        intRef.element = 0;
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "ctx.applicationContext");
                        p pVar = new p(applicationContext, str, intValue, new Function1<Integer, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$setupDataBase$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i3) {
                                Ref.IntRef.this.element = i3;
                            }
                        });
                        this.sqliteOpenHelper = pVar;
                        pVar.getReadableDatabase();
                        return intRef.element;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        }
        return -1;
    }

    private final void x(Object params) {
        if (params != null) {
            final Object[] objArr = (Object[]) params;
            boolean areEqual = Intrinsics.areEqual(objArr[0], (Object) 1);
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$update$task$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SQLiteDatabase r16;
                    int l3;
                    String[] strArr;
                    int i3;
                    r16 = KRSQLiteModule.this.r();
                    if (r16 == null) {
                        return;
                    }
                    r16.beginTransaction();
                    int i16 = 1;
                    while (true) {
                        try {
                            Object[] objArr2 = objArr;
                            if (i16 < objArr2.length) {
                                int i17 = i16 + 1;
                                Object obj = objArr2[i16];
                                if (obj != null) {
                                    String str = (String) obj;
                                    KRSQLiteModule kRSQLiteModule = KRSQLiteModule.this;
                                    int i18 = i17 + 1;
                                    Object obj2 = objArr2[i17];
                                    if (obj2 != null) {
                                        l3 = kRSQLiteModule.l(((Integer) obj2).intValue());
                                        int i19 = i18 + 1;
                                        Object obj3 = objArr[i18];
                                        if (obj3 != null) {
                                            int intValue = ((Integer) obj3).intValue();
                                            ContentValues contentValues = new ContentValues();
                                            int i26 = 0;
                                            int i27 = 0;
                                            while (i27 < intValue) {
                                                Object[] objArr3 = objArr;
                                                int i28 = i19 + 1;
                                                Object obj4 = objArr3[i19];
                                                if (obj4 != null) {
                                                    String str2 = (String) obj4;
                                                    int i29 = i28 + 1;
                                                    Object obj5 = objArr3[i28];
                                                    if (obj5 instanceof String) {
                                                        contentValues.put(str2, (String) obj5);
                                                    } else if (obj5 instanceof Integer) {
                                                        contentValues.put(str2, (Integer) obj5);
                                                    } else if (obj5 instanceof Long) {
                                                        contentValues.put(str2, (Long) obj5);
                                                    } else if (obj5 instanceof Double) {
                                                        contentValues.put(str2, (Double) obj5);
                                                    } else if (obj5 instanceof Float) {
                                                        contentValues.put(str2, (Float) obj5);
                                                    } else if (obj5 instanceof Boolean) {
                                                        contentValues.put(str2, (Boolean) obj5);
                                                    } else if (obj5 instanceof byte[]) {
                                                        contentValues.put(str2, (byte[]) obj5);
                                                    }
                                                    i27++;
                                                    i19 = i29;
                                                } else {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                }
                                            }
                                            Object[] objArr4 = objArr;
                                            int i36 = i19 + 1;
                                            Object obj6 = objArr4[i19];
                                            if (obj6 != null) {
                                                String str3 = (String) obj6;
                                                int i37 = i36 + 1;
                                                Object obj7 = objArr4[i36];
                                                if (obj7 != null) {
                                                    int intValue2 = ((Integer) obj7).intValue();
                                                    if (intValue2 > 0) {
                                                        String[] strArr2 = new String[intValue2];
                                                        while (i26 < intValue2) {
                                                            strArr2[i26] = objArr[i37].toString();
                                                            i26++;
                                                            i37++;
                                                        }
                                                        i3 = i37;
                                                        strArr = strArr2;
                                                    } else {
                                                        strArr = null;
                                                        i3 = i37;
                                                    }
                                                    r16.updateWithOnConflict(str, contentValues, str3, strArr, l3);
                                                    i16 = i3;
                                                } else {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                                }
                                            } else {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                            }
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else {
                                r16.setTransactionSuccessful();
                                break;
                            }
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                    }
                }
            };
            if (areEqual) {
                function0.invoke();
                return;
            } else {
                KRSubThreadScheduler.f118174c.e(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$update$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0.this.invoke();
                    }
                });
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1752606920:
                if (method.equals("setupDataBase")) {
                    return Integer.valueOf(w(params));
                }
                return super.call(method, params, callback);
            case -1335458389:
                if (method.equals("delete")) {
                    o(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1183792455:
                if (method.equals("insert")) {
                    t(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -906021636:
                if (method.equals("select")) {
                    return v(params, callback);
                }
                return super.call(method, params, callback);
            case -838846263:
                if (method.equals("update")) {
                    x(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 539368985:
                if (method.equals("executeSql")) {
                    p(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        KRSubThreadScheduler.f118174c.e(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$onDestroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRSQLiteModule$onDestroy$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        p pVar;
                        pVar = KRSQLiteModule.this.sqliteOpenHelper;
                        if (pVar != null) {
                            pVar.close();
                        }
                        KRSQLiteModule.this.sqliteOpenHelper = null;
                    }
                });
            }
        });
    }
}
