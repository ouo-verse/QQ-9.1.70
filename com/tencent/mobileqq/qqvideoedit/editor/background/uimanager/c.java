package com.tencent.mobileqq.qqvideoedit.editor.background.uimanager;

import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/uimanager/EditUIScene;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$EditScene;", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275278a;

        static {
            int[] iArr = new int[EditUIScene.values().length];
            try {
                iArr[EditUIScene.STICKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EditUIScene.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EditUIScene.PIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EditUIScene.MULTIMEDIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EditUIScene.RATIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EditUIScene.BACKGROUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f275278a = iArr;
        }
    }

    @NotNull
    public static final EditViewContext.EditScene a(@NotNull EditUIScene editUIScene) {
        Intrinsics.checkNotNullParameter(editUIScene, "<this>");
        switch (a.f275278a[editUIScene.ordinal()]) {
            case 1:
                return EditViewContext.EditScene.STICKER;
            case 2:
                return EditViewContext.EditScene.NULL;
            case 3:
                return EditViewContext.EditScene.PIP;
            case 4:
                return EditViewContext.EditScene.MULTIMEDIA;
            case 5:
            case 6:
                return EditViewContext.EditScene.FRAME;
            default:
                return EditViewContext.EditScene.NULL;
        }
    }
}
