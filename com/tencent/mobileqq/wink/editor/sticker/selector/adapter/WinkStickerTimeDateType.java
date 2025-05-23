package com.tencent.mobileqq.wink.editor.sticker.selector.adapter;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002j\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeDateType;", "", "(Ljava/lang/String;I)V", "getColumnCount", "", "getColumnType", "Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeColumnType;", "columnIndex", "getColumnTypeFullTime", "FullTime", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum WinkStickerTimeDateType {
    FullTime;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321759a;

        static {
            int[] iArr = new int[WinkStickerTimeDateType.values().length];
            try {
                iArr[WinkStickerTimeDateType.FullTime.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f321759a = iArr;
        }
    }

    private final WinkStickerTimeColumnType getColumnTypeFullTime(int columnIndex) {
        if (columnIndex != 0) {
            if (columnIndex != 1) {
                if (columnIndex != 2) {
                    if (columnIndex != 3) {
                        if (columnIndex != 4) {
                            return WinkStickerTimeColumnType.TypeYear;
                        }
                        return WinkStickerTimeColumnType.TypeMinute;
                    }
                    return WinkStickerTimeColumnType.TypeHour;
                }
                return WinkStickerTimeColumnType.TypeDay;
            }
            return WinkStickerTimeColumnType.TypeMonth;
        }
        return WinkStickerTimeColumnType.TypeYear;
    }

    public final int getColumnCount() {
        if (a.f321759a[ordinal()] == 1) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final WinkStickerTimeColumnType getColumnType(int columnIndex) {
        if (a.f321759a[ordinal()] == 1) {
            return getColumnTypeFullTime(columnIndex);
        }
        throw new NoWhenBranchMatchedException();
    }
}
