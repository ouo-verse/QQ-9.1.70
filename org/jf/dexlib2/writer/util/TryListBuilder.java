package org.jf.dexlib2.writer.util;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseTryBlock;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TryListBuilder<EH extends ExceptionHandler> {
    private final MutableTryBlock<EH> listEnd;
    private final MutableTryBlock<EH> listStart;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InvalidTryException extends ExceptionWithContext {
        public InvalidTryException(Throwable th5) {
            super(th5);
        }

        public InvalidTryException(Throwable th5, String str, Object... objArr) {
            super(th5, str, objArr);
        }

        public InvalidTryException(String str, Object... objArr) {
            super(str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TryBounds<EH extends ExceptionHandler> {

        @Nonnull
        public final MutableTryBlock<EH> end;

        @Nonnull
        public final MutableTryBlock<EH> start;

        public TryBounds(@Nonnull MutableTryBlock<EH> mutableTryBlock, @Nonnull MutableTryBlock<EH> mutableTryBlock2) {
            this.start = mutableTryBlock;
            this.end = mutableTryBlock2;
        }
    }

    public TryListBuilder() {
        MutableTryBlock<EH> mutableTryBlock = new MutableTryBlock<>(0, 0);
        this.listStart = mutableTryBlock;
        MutableTryBlock<EH> mutableTryBlock2 = new MutableTryBlock<>(0, 0);
        this.listEnd = mutableTryBlock2;
        mutableTryBlock.next = mutableTryBlock2;
        mutableTryBlock2.prev = mutableTryBlock;
    }

    private TryBounds<EH> getBoundingRanges(int i3, int i16) {
        MutableTryBlock<EH> mutableTryBlock = this.listStart.next;
        while (true) {
            if (mutableTryBlock != this.listEnd) {
                int i17 = mutableTryBlock.startCodeAddress;
                int i18 = mutableTryBlock.endCodeAddress;
                if (i3 == i17) {
                    break;
                }
                if (i3 > i17 && i3 < i18) {
                    mutableTryBlock = mutableTryBlock.split(i3);
                    break;
                }
                if (i3 < i17) {
                    if (i16 <= i17) {
                        MutableTryBlock<EH> mutableTryBlock2 = new MutableTryBlock<>(i3, i16);
                        mutableTryBlock.prepend(mutableTryBlock2);
                        return new TryBounds<>(mutableTryBlock2, mutableTryBlock2);
                    }
                    MutableTryBlock<EH> mutableTryBlock3 = new MutableTryBlock<>(i3, i17);
                    mutableTryBlock.prepend(mutableTryBlock3);
                    mutableTryBlock = mutableTryBlock3;
                } else {
                    mutableTryBlock = mutableTryBlock.next;
                }
            } else {
                mutableTryBlock = null;
                break;
            }
        }
        if (mutableTryBlock == null) {
            MutableTryBlock<EH> mutableTryBlock4 = new MutableTryBlock<>(i3, i16);
            this.listEnd.prepend(mutableTryBlock4);
            return new TryBounds<>(mutableTryBlock4, mutableTryBlock4);
        }
        MutableTryBlock<EH> mutableTryBlock5 = mutableTryBlock;
        while (true) {
            MutableTryBlock<EH> mutableTryBlock6 = this.listEnd;
            if (mutableTryBlock5 != mutableTryBlock6) {
                int i19 = mutableTryBlock5.startCodeAddress;
                int i26 = mutableTryBlock5.endCodeAddress;
                if (i16 == i26) {
                    return new TryBounds<>(mutableTryBlock, mutableTryBlock5);
                }
                if (i16 > i19 && i16 < i26) {
                    mutableTryBlock5.split(i16);
                    return new TryBounds<>(mutableTryBlock, mutableTryBlock5);
                }
                if (i16 <= i19) {
                    MutableTryBlock<EH> mutableTryBlock7 = new MutableTryBlock<>(mutableTryBlock5.prev.endCodeAddress, i16);
                    mutableTryBlock5.prepend(mutableTryBlock7);
                    return new TryBounds<>(mutableTryBlock, mutableTryBlock7);
                }
                mutableTryBlock5 = mutableTryBlock5.next;
            } else {
                MutableTryBlock<EH> mutableTryBlock8 = new MutableTryBlock<>(mutableTryBlock6.prev.endCodeAddress, i16);
                this.listEnd.prepend(mutableTryBlock8);
                return new TryBounds<>(mutableTryBlock, mutableTryBlock8);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <EH extends ExceptionHandler> List<TryBlock<EH>> massageTryBlocks(List<? extends TryBlock<? extends EH>> list) {
        TryListBuilder tryListBuilder = new TryListBuilder();
        for (TryBlock<? extends EH> tryBlock : list) {
            int startCodeAddress = tryBlock.getStartCodeAddress();
            int codeUnitCount = tryBlock.getCodeUnitCount() + startCodeAddress;
            Iterator<? extends Object> it = tryBlock.getExceptionHandlers().iterator();
            while (it.hasNext()) {
                tryListBuilder.addHandler(startCodeAddress, codeUnitCount, (ExceptionHandler) it.next());
            }
        }
        return tryListBuilder.getTryBlocks();
    }

    public void addHandler(int i3, int i16, EH eh5) {
        TryBounds<EH> boundingRanges = getBoundingRanges(i3, i16);
        MutableTryBlock<EH> mutableTryBlock = boundingRanges.start;
        MutableTryBlock<EH> mutableTryBlock2 = boundingRanges.end;
        do {
            int i17 = mutableTryBlock.startCodeAddress;
            if (i17 > i3) {
                MutableTryBlock<EH> mutableTryBlock3 = new MutableTryBlock<>(i3, i17);
                mutableTryBlock.prepend(mutableTryBlock3);
                mutableTryBlock = mutableTryBlock3;
            }
            mutableTryBlock.addHandler(eh5);
            i3 = mutableTryBlock.endCodeAddress;
            mutableTryBlock = mutableTryBlock.next;
        } while (mutableTryBlock.prev != mutableTryBlock2);
    }

    public List<TryBlock<EH>> getTryBlocks() {
        return Lists.j(new Iterator<TryBlock<EH>>() { // from class: org.jf.dexlib2.writer.util.TryListBuilder.1

            @Nullable
            private MutableTryBlock<EH> next;

            {
                this.next = TryListBuilder.this.listStart;
                this.next = readNextItem();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.next != null) {
                    return true;
                }
                return false;
            }

            @Nullable
            protected MutableTryBlock<EH> readNextItem() {
                MutableTryBlock<EH> mutableTryBlock = this.next.next;
                if (mutableTryBlock == TryListBuilder.this.listEnd) {
                    return null;
                }
                while (mutableTryBlock.next != TryListBuilder.this.listEnd && mutableTryBlock.endCodeAddress == mutableTryBlock.next.startCodeAddress && mutableTryBlock.getExceptionHandlers().equals(mutableTryBlock.next.getExceptionHandlers())) {
                    mutableTryBlock.mergeNext();
                }
                return mutableTryBlock;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            @Nonnull
            public TryBlock<EH> next() {
                if (hasNext()) {
                    MutableTryBlock<EH> mutableTryBlock = this.next;
                    this.next = readNextItem();
                    return mutableTryBlock;
                }
                throw new NoSuchElementException();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MutableTryBlock<EH extends ExceptionHandler> extends BaseTryBlock<EH> {
        public int endCodeAddress;

        @Nonnull
        public List<EH> exceptionHandlers;
        public MutableTryBlock<EH> next;
        public MutableTryBlock<EH> prev;
        public int startCodeAddress;

        public MutableTryBlock(int i3, int i16) {
            this.prev = null;
            this.next = null;
            this.exceptionHandlers = Lists.h();
            this.startCodeAddress = i3;
            this.endCodeAddress = i16;
        }

        public void addHandler(@Nonnull EH eh5) {
            for (EH eh6 : this.exceptionHandlers) {
                String exceptionType = eh6.getExceptionType();
                String exceptionType2 = eh5.getExceptionType();
                if (exceptionType == null) {
                    if (exceptionType2 == null) {
                        if (eh6.getHandlerCodeAddress() == eh5.getHandlerCodeAddress()) {
                            return;
                        } else {
                            throw new InvalidTryException("Multiple overlapping catch all handlers with different handlers", new Object[0]);
                        }
                    }
                } else if (exceptionType.equals(exceptionType2)) {
                    return;
                }
            }
            this.exceptionHandlers.add(eh5);
        }

        public void append(@Nonnull MutableTryBlock<EH> mutableTryBlock) {
            MutableTryBlock<EH> mutableTryBlock2 = this.next;
            mutableTryBlock2.prev = mutableTryBlock;
            mutableTryBlock.next = mutableTryBlock2;
            mutableTryBlock.prev = this;
            this.next = mutableTryBlock;
        }

        public void delete() {
            MutableTryBlock<EH> mutableTryBlock = this.next;
            mutableTryBlock.prev = this.prev;
            this.prev.next = mutableTryBlock;
        }

        @Override // org.jf.dexlib2.iface.TryBlock
        public int getCodeUnitCount() {
            return this.endCodeAddress - this.startCodeAddress;
        }

        @Override // org.jf.dexlib2.iface.TryBlock
        @Nonnull
        public List<EH> getExceptionHandlers() {
            return this.exceptionHandlers;
        }

        @Override // org.jf.dexlib2.iface.TryBlock
        public int getStartCodeAddress() {
            return this.startCodeAddress;
        }

        public void mergeNext() {
            MutableTryBlock<EH> mutableTryBlock = this.next;
            this.endCodeAddress = mutableTryBlock.endCodeAddress;
            mutableTryBlock.delete();
        }

        public void prepend(@Nonnull MutableTryBlock<EH> mutableTryBlock) {
            MutableTryBlock<EH> mutableTryBlock2 = this.prev;
            mutableTryBlock2.next = mutableTryBlock;
            mutableTryBlock.prev = mutableTryBlock2;
            mutableTryBlock.next = this;
            this.prev = mutableTryBlock;
        }

        @Nonnull
        public MutableTryBlock<EH> split(int i3) {
            MutableTryBlock<EH> mutableTryBlock = new MutableTryBlock<>(i3, this.endCodeAddress, this.exceptionHandlers);
            this.endCodeAddress = i3;
            append(mutableTryBlock);
            return mutableTryBlock;
        }

        public MutableTryBlock(int i3, int i16, @Nonnull List<EH> list) {
            this.prev = null;
            this.next = null;
            this.exceptionHandlers = Lists.h();
            this.startCodeAddress = i3;
            this.endCodeAddress = i16;
            this.exceptionHandlers = Lists.i(list);
        }
    }
}
