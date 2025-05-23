package com.tencent.mobileqq.shortvideo;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface ab {
    void a(int i3, y yVar);

    void b(int i3, ArrayList<y> arrayList);

    void c(int i3, y yVar);

    void onUpdateProgress(int i3);

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static abstract class b implements ab {
        @Override // com.tencent.mobileqq.shortvideo.ab
        public void onUpdateProgress(int i3) {
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void a(int i3, y yVar) {
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void c(int i3, y yVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static abstract class a implements ab {
        @Override // com.tencent.mobileqq.shortvideo.ab
        public void b(int i3, ArrayList<y> arrayList) {
        }

        @Override // com.tencent.mobileqq.shortvideo.ab
        public void c(int i3, y yVar) {
        }
    }
}
